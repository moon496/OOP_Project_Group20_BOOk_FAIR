package com.group20.oop_project_group20_book_fair.Moon;

import com.group20.oop_project_group20_book_fair.screenSwitcher;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.*;

public class SeminarEventController {

    @FXML
    private TableColumn<SeminarEvent, Integer> SeatCol;
    @FXML
    private TableColumn<SeminarEvent, String> TimeCol;
    @FXML
    private TableColumn<SeminarEvent, String> nameCol;
    @FXML
    private TableView<SeminarEvent> eventTable;
    @FXML
    private Label textView;
    @FXML
    private ChoiceBox<String> filterType;
    @FXML
    private TableColumn<SeminarEvent, String> DateCol;

    private static final String EVENT_FILE = "./data/organized_events.txt";

    private ObservableList<SeminarEvent> Eventlist = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Controller initialized.");

        nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        DateCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate()));
        TimeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTime()));
        SeatCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getSeats()).asObject());

        filterType.getItems().addAll("All", "Seminar", "Workshop", "Discussion");
        filterType.setValue("All");

        loadEvents();
    }

    // ✅ FIXED: Now loads ONLY from file (no duplicate dummies)
    private void loadEvents() {
        Eventlist.clear();
        System.out.println("Starting to load events...");

        File file = new File(EVENT_FILE);
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("File exists: " + file.exists());

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int loadedCount = 0;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Reading line: " + line);
                    String[] parts = line.split(",");

                    // ✅ FIXED: Now expects 6 parts (name,date,time,venue,seats,type)
                    if (parts.length == 6) {
                        String name = parts[0].trim();
                        String date = parts[1].trim();
                        String time = parts[2].trim();
                        String venue = parts[3].trim();  // ✅ Now reading venue
                        int seats;
                        try {
                            seats = Integer.parseInt(parts[4].trim());
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid seat number: " + parts[4] + ". Skipping event.");
                            continue;
                        }
                        String type = parts[5].trim();

                        // ✅ Only load Seminar/Workshop/Discussion events (not Meet-the-Author)
                        if (type.equalsIgnoreCase("Seminar") ||
                                type.equalsIgnoreCase("Workshop") ||
                                type.equalsIgnoreCase("Discussion")) {
                            Eventlist.add(new SeminarEvent(name, date, time, seats, type));
                            loadedCount++;
                        }
                    } else {
                        System.err.println("Invalid line format (expected 6 parts): " + line);
                    }
                }
                System.out.println("Loaded " + loadedCount + " seminar/workshop events from file.");
                textView.setText(loadedCount + " events loaded successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                textView.setText("Error loading events from file!");
            }
        } else {
            textView.setText("File not found! Please create events in Organizer panel.");
        }

        eventTable.setItems(Eventlist);
    }

    // ✅ FIXED: Now saves with venue field
    private void saveEvents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EVENT_FILE))) {
            for (SeminarEvent event : Eventlist) {
                // ✅ Match OrganizerEventController format: name,date,time,venue,seats,type
                writer.write(event.getName() + "," +
                        event.getDate() + "," +
                        event.getTime() + "," +
                        "Unknown Venue," +  // ⚠️ Venue not stored in SeminarEvent model
                        event.getSeats() + "," +
                        event.getType());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            textView.setText("Error saving events.");
        }
    }

    @FXML
    public void JoinEvent(ActionEvent actionEvent) {
        SeminarEvent selected = eventTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            textView.setText("Please select an event to join!");
            return;
        }

        if (selected.getSeats() > 0) {
            selected.setSeats(selected.getSeats() - 1);
            eventTable.refresh();
            textView.setText("Successfully registered for: " + selected.getName());
            saveEvents();  // Persist changes
        } else {
            textView.setText("No seats available!");
        }
    }

    @FXML
    public void Refresh(ActionEvent actionEvent) {
        loadEvents();
        textView.setText("Event list refreshed!");
    }

    @FXML
    public void Filter(ActionEvent actionEvent) {
        String filter = filterType.getValue();
        if (filter.equals("All")) {
            eventTable.setItems(Eventlist);
            return;
        }

        ObservableList<SeminarEvent> filtered = FXCollections.observableArrayList();
        for (SeminarEvent e : Eventlist) {
            if (e.getType().equalsIgnoreCase(filter)) {
                filtered.add(e);
            }
        }
        eventTable.setItems(filtered);
    }

    @FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("Moon/ComplainSecurityOfficer.fxml");
    }

    @FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("Moon/GiveFeedback.fxml");
    }

    @FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("Moon/Customer.fxml");
    }
}
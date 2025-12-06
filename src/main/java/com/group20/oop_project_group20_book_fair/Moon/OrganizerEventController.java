package com.group20.oop_project_group20_book_fair.Moon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;
import static java.lang.Integer.parseInt;

public class OrganizerEventController {

    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField namefield;
    @javafx.fxml.FXML
    private Label textfield;
    @javafx.fxml.FXML
    private TextField time;
    @javafx.fxml.FXML
    private ComboBox<String> EventBox;
    @javafx.fxml.FXML
    private TextField vanue;
    @javafx.fxml.FXML
    private TableView<EventModel> Tableview;
    @javafx.fxml.FXML
    private TableColumn<EventModel, String> DateCol;
    @javafx.fxml.FXML
    private TableColumn<EventModel, String> NameCol;
    @javafx.fxml.FXML
    private TableColumn<EventModel, String> TimeCol;
    @javafx.fxml.FXML
    private TableColumn<EventModel, String> VanueCol;
    @javafx.fxml.FXML
    private TableColumn<EventModel, Integer> SeatCol;
    @javafx.fxml.FXML
    private TextField seatNo;

    private ObservableList<EventModel> eventList = FXCollections.observableArrayList();
    private static final String EVENT_FILE = "./data/organized_events.txt";

    @javafx.fxml.FXML
    public void initialize() {
        EventBox.getItems().addAll("Seminar", "Workshop", "Discussion", "Meet-the-Author");

        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TimeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        VanueCol.setCellValueFactory(new PropertyValueFactory<>("venue"));
        SeatCol.setCellValueFactory(new PropertyValueFactory<>("seats"));

        // ✅ Ensure directory and file exists with dummy data
        ensureFileHasData();
        loadEventsFromFile();
        Tableview.setItems(eventList);
    }

    // ✅ Creates data directory and file with dummy data if missing
    private void ensureFileHasData() {
        File dataDir = new File("./data");
        File file = new File(EVENT_FILE);

        // Create data directory if not exists
        if (!dataDir.exists()) {
            boolean created = dataDir.mkdirs();
            System.out.println("Data directory created: " + created);
        }

        // Check if file needs initialization
        boolean needsInitialization = false;

        if (!file.exists()) {
            needsInitialization = true;
            System.out.println("📁 File doesn't exist. Creating with dummy data...");
        } else {
            // Check if file has valid data
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int validLines = 0;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty() && line.split(",").length == 6) {
                        validLines++;
                    }
                }
                if (validLines == 0) {
                    needsInitialization = true;
                    System.out.println("📁 File exists but empty. Adding dummy data...");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Write dummy data if needed
        if (needsInitialization) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {  // false = overwrite
                writer.write("AI and Machine Learning,10-12-2025,2:00 PM,BICC Hall A,50,Seminar\n");
                writer.write("Digital Marketing Basics,14-12-2025,4:00 PM,Book Fair Stage 2,35,Seminar\n");
                writer.write("Blockchain for Beginners,15-12-2025,3:00 PM,Seminar Room 1,45,Seminar\n");
                writer.write("Cybersecurity Awareness,19-12-2025,1:00 PM,Seminar Hall 4,20,Seminar\n");
                writer.write("Creative Writing Workshop,20-12-2025,11:00 AM,Workshop Tent,18,Workshop\n");
                writer.write("Meet Author Jasim Uddin,12-12-2025,11:00 AM,Shishu Academy,40,Meet-the-Author\n");
                writer.write("Meet Writer Humayun Kabir,16-12-2025,12:00 PM,Hall 3,60,Meet-the-Author\n");
                writer.write("Poetry with Nirmalendu Goon,18-12-2025,3:30 PM,Literature Stage,50,Meet-the-Author\n");
                System.out.println("✅ Dummy data initialized successfully!");
            } catch (IOException e) {
                System.err.println("❌ Error writing dummy data: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("✅ File already has data. Skipping initialization.");
        }
    }

    private void loadEventsFromFile() {
        eventList.clear();
        File file = new File(EVENT_FILE);

        if (!file.exists()) {
            System.err.println("❌ File not found: " + file.getAbsolutePath());
            textfield.setText("File not found!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int loaded = 0;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;  // Skip empty lines

                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String name = parts[0].trim();
                    String date = parts[1].trim();
                    String time = parts[2].trim();
                    String venue = parts[3].trim();
                    int seats = parseInt(parts[4].trim());
                    String type = parts[5].trim();
                    eventList.add(new EventModel(name, date, time, venue, type, seats));
                    loaded++;
                } else {
                    System.err.println("⚠ Invalid format: " + line);
                }
            }
            System.out.println("✅ Loaded " + loaded + " events from file");
            textfield.setText("Loaded " + loaded + " events successfully!");
        } catch (IOException e) {
            System.err.println("❌ Error loading file: " + e.getMessage());
            e.printStackTrace();
            textfield.setText("Error loading events!");
        }
    }

    @javafx.fxml.FXML
    public void clear(ActionEvent actionEvent) {
        EventBox.setValue(null);
        namefield.clear();
        date.setValue(null);
        time.clear();
        vanue.clear();
        seatNo.clear();
        textfield.setText("Form cleared.");
    }

    @javafx.fxml.FXML
    public void save(ActionEvent actionEvent) {
        String name = namefield.getText();
        LocalDate eventDate = date.getValue();
        String eventType = EventBox.getValue();
        String eventTime = time.getText();
        String venue = vanue.getText();
        String seatsText = seatNo.getText();

        // Validation
        if (name.isEmpty() || eventDate == null || eventType == null ||
                eventTime.isEmpty() || venue.isEmpty() || seatsText.isEmpty()) {
            textfield.setText("⚠ Please fill all fields!");
            return;
        }

        int seats;
        try {
            seats = parseInt(seatsText);
            if (seats <= 0) {
                textfield.setText("⚠ Seats must be positive!");
                return;
            }
        } catch (NumberFormatException e) {
            textfield.setText("⚠ Seats must be a valid number!");
            return;
        }

        // Create new event
        EventModel newEvent = new EventModel(name, eventDate.toString(), eventTime, venue, eventType, seats);

        // ✅ Save to file FIRST, then add to list
        boolean saved = saveEventToFile(name, eventDate.toString(), eventTime, venue, seats, eventType);

        if (saved) {
            eventList.add(newEvent);
            Tableview.refresh();
            textfield.setText("✅ Event '" + name + "' created successfully!");

            // Clear form after successful save
            clear(actionEvent);
        } else {
            textfield.setText("❌ Failed to save event to file!");
        }
    }

    // ✅ Returns true if save successful
    private boolean saveEventToFile(String name, String date, String time, String venue, int seats, String type) {
        File file = new File(EVENT_FILE);
        File dataDir = new File("./data");

        // Ensure directory exists
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {  // true = append mode
            writer.write(name + "," + date + "," + time + "," + venue + "," + seats + "," + type);
            writer.newLine();
            System.out.println("✅ Saved to file: " + name);
            return true;
        } catch (IOException e) {
            System.err.println("❌ Error saving to file: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @javafx.fxml.FXML
    public void loadTable(ActionEvent actionEvent) {
        loadEventsFromFile();
        Tableview.setItems(eventList);
        textfield.setText("✅ Table reloaded! Total: " + eventList.size() + " events");
    }

    @javafx.fxml.FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        switchTo("Login.fxml");
    }

    @javafx.fxml.FXML
    public void back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Publisher.fxml");
    }

    @javafx.fxml.FXML
    public void dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Publisher.fxml");
    }
}
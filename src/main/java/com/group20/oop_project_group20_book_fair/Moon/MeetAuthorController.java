package com.group20.oop_project_group20_book_fair.Moon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class MeetAuthorController {
    @javafx.fxml.FXML
    private TextField timefield;
    @javafx.fxml.FXML
    private TextField feedback;
    @javafx.fxml.FXML
    private TableColumn<MeetAuthor, String> Authorcol;
    @javafx.fxml.FXML
    private TableColumn<MeetAuthor, String> Timecol;
    @javafx.fxml.FXML
    private TextField namefield;
    @javafx.fxml.FXML
    private TableColumn<MeetAuthor, String> Eventcol;
    @javafx.fxml.FXML
    private TableView<MeetAuthor> tableView;
    @javafx.fxml.FXML
    private TextField eventfield;
    @javafx.fxml.FXML
    private TableColumn<MeetAuthor, String> Vanue;
    @javafx.fxml.FXML
    private ChoiceBox<String> vanue;
    @javafx.fxml.FXML
    private Label date;
    @javafx.fxml.FXML
    private VBox RegiBox;
    @javafx.fxml.FXML
    private Label name;
    @javafx.fxml.FXML
    private Label time;

    ObservableList<MeetAuthor> list = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    private Label textview;

    @javafx.fxml.FXML
    public void initialize() {

        Authorcol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getAuthorName()));
        Eventcol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getEventName()));
        Timecol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getTime()));
        Vanue.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getVenue()));


        list = loadEventsFromFile();
        tableView.setItems(list);


        vanue.setItems(FXCollections.observableArrayList(
                "Main Hall", "Hall A", "Hall B", "Hall C", "Garden Area",
                "Auditorium", "Studio Room", "Hall 1", "Hall 2", "Hall 3", "Hall 4"
        ));


        date.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));


        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                MeetAuthor selected = tableView.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    namefield.setText(selected.getAuthorName());
                    eventfield.setText(selected.getEventName());
                    timefield.setText(selected.getTime());
                    vanue.setValue(selected.getVenue());
                }
            }
        });
    }

    @javafx.fxml.FXML
    public void Cancle(ActionEvent actionEvent) {
        namefield.clear();
        eventfield.clear();
        timefield.clear();
        vanue.setValue(null);
        name.setText("");
        time.setText("");
        textview.setText("⚠ Form cleared.");
    }

    @javafx.fxml.FXML
    public void Register(ActionEvent actionEvent) {
        String nameText = namefield.getText();
        String eventText = eventfield.getText();
        String timeText = timefield.getText();
        String venueText = vanue.getValue();

        if (nameText.isEmpty() || eventText.isEmpty() || timeText.isEmpty() || venueText == null) {
            textview.setText("⚠ Please fill all fields before registering.");
            return;
        }

        name.setText(nameText);
        time.setText(timeText);
        textview.setText("Registration successful! Please click 'Confirm Registration'.");
    }

    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/GiveFeedback.fxml");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/WishListCollection.fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Customer.fxml");
    }

    @javafx.fxml.FXML
    public void Confirm(ActionEvent actionEvent) {
        if (name.getText().isEmpty()) {
            textview.setText("⚠ No registration found. Please register first.");
            return;
        }
        textview.setText("✔ Registration confirmed for " + name.getText() + "!");
    }

    @javafx.fxml.FXML
    public void Submitfeedback(ActionEvent actionEvent) {
        String feedbackText = feedback.getText();

        if (feedbackText.isEmpty()) {
            textview.setText("⚠ No feedback entered. Please provide feedback.");
            return;
        }
        textview.setText("✔ Thank you! Your feedback has been submitted.");
        feedback.clear();
    }


    private ObservableList<MeetAuthor> loadEventsFromFile() {
        ObservableList<MeetAuthor> list = FXCollections.observableArrayList();
        File file = new File("./data/organized_events.txt");

        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("File exists: " + file.exists());

        try {
            if (!file.exists()) {
                System.out.println("File not found. Ensure OrganizerEventController has initialized it.");
                return list;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line);
                String[] parts = line.split(",");

                if (parts.length == 6) {

                    String eventName = parts[0].trim();
                    String eventDate = parts[1].trim();
                    String eventTime = parts[2].trim();
                    String eventVenue = parts[3].trim();
                    String seats = parts[4].trim();
                    String eventType = parts[5].trim();


                    if (eventType.equalsIgnoreCase("Meet-the-Author")) {

                        MeetAuthor event = new MeetAuthor(
                                eventName,
                                eventType,
                                eventDate,
                                eventTime,
                                eventVenue,
                                seats
                        );
                        list.add(event);
                        System.out.println("Added: " + event.getAuthorName() + " | " + event.getEventName());
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
            reader.close();

            System.out.println("Total Meet-the-Author events loaded: " + list.size());

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }
}
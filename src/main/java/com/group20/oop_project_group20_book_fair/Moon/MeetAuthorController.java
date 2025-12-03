package com.group20.oop_project_group20_book_fair.Moon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class MeetAuthorController
{
    @javafx.fxml.FXML
    private TextField timefield;
    @javafx.fxml.FXML
    private TextField feedback;
    @javafx.fxml.FXML
    private TableColumn <MeetAuthor , String> Authorcol;
    @javafx.fxml.FXML
    private TableColumn <MeetAuthor , String> Timecol;
    @javafx.fxml.FXML
    private TextField namefield;
    @javafx.fxml.FXML
    private TableColumn <MeetAuthor , String> Eventcol;
    @javafx.fxml.FXML
    private TableView <MeetAuthor> tableView;
    @javafx.fxml.FXML
    private TextField eventfield;
    @javafx.fxml.FXML
    private TableColumn <MeetAuthor , String> Vanue;
    @javafx.fxml.FXML
    private ChoiceBox <String> vanue;
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

        list.addAll(
                new MeetAuthor("Humayun Ahmed", "Book Signing", "3:00 PM", "Hall A"),
                new MeetAuthor("Jafor Iqbal", "Workshop", "5:00 PM", "Hall B"),
                new MeetAuthor("Anisul Haque", "Meet & Greet", "2:00 PM", "Hall C"),
                new MeetAuthor("J.K. Rowling", "Fantasy Writing Workshop", "10:00 AM", "Main Hall"),
                new MeetAuthor("Stephen King", "Horror Storytelling", "2:00 PM", "Conference Room A"));

        tableView.setItems(list);

        vanue.setItems(FXCollections.observableArrayList("Main Hall","Hall A", "Hall B", "Hall C","Garden Area"));
        date.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        name.setText(String.valueOf(namefield));
        time.setText(String.valueOf(timefield));


        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                MeetAuthor selected = tableView.getSelectionModel().getSelectedItem();
                if (selected != null) {
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

        textview.setText( "Cancelled");
    }


    @javafx.fxml.FXML
    public void Register(ActionEvent actionEvent) {
        String nameText = namefield.getText();
        String eventText = eventfield.getText();
        String timeText = timefield.getText();
        String venueText = vanue.getValue();

        if (nameText.isEmpty() || eventText.isEmpty() || timeText.isEmpty() || venueText == null) {

            textview.setText( "Missing Information Please fill in all fields before registering.");
            return;
        }
        name.setText(nameText);
        time.setText(timeText);

        textview.setText( "Registration Pending Please click 'Confirm Registration' to complete your registration.");
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
            textview.setText( "No Registration Please register first before confirming.");
            return;
        }

        textview.setText( "Success Registration confirmed for " + name.getText() + "!");
    }



    @javafx.fxml.FXML
    public void Submitfeedback(ActionEvent actionEvent) {
        String feedbackText = feedback.getText();

        if (feedbackText.isEmpty()) {
            textview.setText("No Feedback Please enter your feedback before submitting.");
            return;
        }

        textview.setText("Thank You Your feedback has been submitted successfully!");
        feedback.clear();
    }

}


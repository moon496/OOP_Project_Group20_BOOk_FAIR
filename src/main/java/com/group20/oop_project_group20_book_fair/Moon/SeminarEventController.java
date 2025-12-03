package com.group20.oop_project_group20_book_fair.Moon;

import com.group20.oop_project_group20_book_fair.screenSwitcher;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.group20.oop_project_group20_book_fair.BaseController.switchTo;

public class SeminarEventController
{
    @javafx.fxml.FXML
    private TableColumn <SeminarEvent , Integer>SeatCol;
    @javafx.fxml.FXML
    private TableColumn <SeminarEvent , String> TimeCol;
    @javafx.fxml.FXML
    private TableColumn <SeminarEvent , String> nameCol;
    @javafx.fxml.FXML
    private TableView <SeminarEvent>eventTable;
    @javafx.fxml.FXML
    private Label textView;
    @javafx.fxml.FXML
    private ChoiceBox <String> filterType;
    @javafx.fxml.FXML
    private TableColumn <SeminarEvent , String> DateCol;

    private ObservableList<SeminarEvent> Eventlist = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));
        DateCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDate()));
        TimeCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTime()));
        SeatCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getSeats()).asObject());

        filterType.getItems().addAll("All", "Seminar", "Workshop", "Discussion");
        filterType.setValue("All");

        loadEvents();

    }



        private void loadEvents() {
            Eventlist.clear();

            Eventlist.add(new SeminarEvent("AI and Machine Learning Seminar", "10-12-2025", "2:00 PM", 20, "Seminar"));
            Eventlist.add(new SeminarEvent("Digital Marketing Strategies", "12-12-2025", "10:00 AM", 25, "Seminar"));
            Eventlist.add(new SeminarEvent("Blockchain Technology Seminar", "15-12-2025", "3:00 PM", 18, "Seminar"));
            Eventlist.add(new SeminarEvent("Future of Publishing", "18-12-2025", "11:00 AM", 30, "Seminar"));
            Eventlist.add(new SeminarEvent("Cybersecurity Awareness", "20-12-2025", "1:00 PM", 22, "Seminar"));
            Eventlist.add(new SeminarEvent("Climate Change and Literature", "22-12-2025", "4:00 PM", 15, "Seminar"));
            eventTable.setItems(Eventlist);
        }



    @javafx.fxml.FXML
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
        } else {
            textView.setText("No seats available!");
        }
    }

    @javafx.fxml.FXML
    public void Refresh(ActionEvent actionEvent) {
        loadEvents();
        textView.setText("Event list refreshed!");
    }



    @javafx.fxml.FXML
    public void Filter(ActionEvent actionEvent) {
        String filter = filterType.getValue();

        if (filter.equals("All")) {
            eventTable.setItems((ObservableList<SeminarEvent>) Eventlist);
            return;
        }

        ObservableList<SeminarEvent> filtered = FXCollections.observableArrayList();

        for (SeminarEvent e : Eventlist) {
            if (e.getType().equals(filter)) {
                filtered.add(e);
            }
        }

        eventTable.setItems(filtered);
    }

    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("Moon/ComplainSecurityOfficer.fxml");

    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("Moon/GiveFeedback.fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("Moon/Customer.fxml");
    }
}
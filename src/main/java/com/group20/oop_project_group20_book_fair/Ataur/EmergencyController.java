package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class EmergencyController
{
    @FXML
    private Label showdetails;
    @FXML
    private ComboBox <String>typeCB;
    @FXML
    private TextField details;
    @FXML
    private TextField id;
    @FXML
    private DatePicker datepicker;

    @FXML
    public void initialize() {
        ComboBox<String> comboBox = typeCB;
        comboBox.getItems().setAll("Fire", "Medical", "Security", "Other");
        comboBox.setOnAction(e -> {
            String selected = comboBox.getSelectionModel().getSelectedItem();
            showdetails.setText("Selected Emergency Type: " + selected);
        });

        datepicker.setOnAction(e -> {
            String selectedDate = datepicker.getValue().toString();
            showdetails.setText(showdetails.getText() + ", Date: " + selectedDate);
        });

    }

    @FXML
    public void nextbutton(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/Parking.fxml");
    }

    @FXML
    public void dashboardbutton(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/SecurityOfficerDashboard.fxml");
    }

    @FXML
    public void previousbutton(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/AlertNotifications.fxml");
    }

    @FXML
    public void savedata(ActionEvent actionEvent) {
        String emergencyType = typeCB.getValue();
        String detailText = details.getText().trim();
        String idText = id.getText().trim();
        String dateText = (datepicker.getValue() != null) ? datepicker.getValue().toString() : "No date selected";

        String displayText = "Emergency Report Saved:\n"
                + "Type: " + emergencyType + "\n"
                + "Details: " + detailText + "\n"
                + "ID: " + idText + "\n"
                + "Date: " + dateText;

        showdetails.setText(displayText);
    }
}
package com.group20.oop_project_group20_book_fair.Moon;

import com.group20.oop_project_group20_book_fair.screenSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class ComplainSecurityController
{
    @javafx.fxml.FXML
    private TextField boothNum;
    @javafx.fxml.FXML
    private ComboBox <String> ReportBox;
    @javafx.fxml.FXML
    private TextArea details;
    @javafx.fxml.FXML
    private ComboBox <String> issueBox;

   List<SecurityComplain> complaintList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        issueBox.getItems().addAll(
                "Theft / Suspicious Activity", "Unauthorized Entry", "Fire Hazard", "Medical Emergency", "Crowd Control Issue", "Lost & Found", "Equipment Malfunction", "Harassment", "Safety Violation", "Other Security Concern");
        issueBox.setPromptText("Select Issue Type");

        ReportBox.getItems().addAll(
                "Security Officer", "Event Manager", "Facility Manager");
        ReportBox.setPromptText("Select Recipient");

        issueBox.setValue("Theft / Suspicious Activity");
        ReportBox.setValue("Security Officer");

        details.setPromptText("Please describe the security issue in detail...");

    }

    @javafx.fxml.FXML
    public void Logout(ActionEvent actionEvent) throws IOException {
        switchTo("Login.fxml");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/SeminarEvent .fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Customer.fxml");
    }

    @javafx.fxml.FXML
    public void Submit(ActionEvent actionEvent) {
        String booth = boothNum.getText();
        String report = ReportBox.getValue();
        String issue = issueBox.getValue();
        String detailText = details.getText();

        if (booth.isEmpty() || report == null || issue == null || detailText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields before submitting.");
            alert.showAndWait();
            return;
        }


        System.out.println("Complaint Submitted:");
        System.out.println("Booth: " + booth);
        System.out.println("Report Type: " + report);
        System.out.println("Issue Type: " + issue);
        System.out.println("Details: " + detailText);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Complaint submitted successfully!");
        alert.showAndWait();


        Clear(actionEvent);
        }





    @javafx.fxml.FXML
    public void Clear(ActionEvent actionEvent) {
        boothNum.clear();
        ReportBox.getSelectionModel().clearSelection();
        issueBox.getSelectionModel().clearSelection();
        details.clear();
    }
}
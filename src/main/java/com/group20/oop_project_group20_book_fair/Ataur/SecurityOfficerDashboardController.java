package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class SecurityOfficerDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void buttonLogout(ActionEvent actionEvent) throws IOException {
        switchTo("Login.fxml");


    }

    @javafx.fxml.FXML
    public void buttonGateMonitoring(ActionEvent actionEvent)throws IOException {
        switchTo("Ataur/GateMonitoring.fxml");
    }

    @javafx.fxml.FXML
    public void buttonDailyReport(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/DailyReport.fxml");
    }

    @javafx.fxml.FXML
    public void buttonAlertNotifications(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/AlertNotification.fxml");
    }


    @javafx.fxml.FXML
    public void buttonParkingManagement(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/Parking.fxml");
    }

    @javafx.fxml.FXML
    public void buttonAccessControl(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/AccessControl.fxml");
    }

    @javafx.fxml.FXML
    public void buttonEmergencyResponse(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/Emergency.fxml");
    }

    @javafx.fxml.FXML
    public void buttonLostFound(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/LostFound.fxml");
    }
}
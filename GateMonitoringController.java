package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GateMonitoringController
{
    @javafx.fxml.FXML
    private TextField txtGateName;
    @javafx.fxml.FXML
    private TextField txtVisitorCount;
    @javafx.fxml.FXML
    private TextField txtCapacity;
    @javafx.fxml.FXML
    private TextField txtCapacity11;
    @javafx.fxml.FXML
    private TextField txtCapacity1;
    @javafx.fxml.FXML
    private Label showdata;
    @FXML
    private TextField txtInput;
    @FXML
    private Label lblDisplay;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void handleExport(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleAddGate(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void handleRefresh(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GateMonitoring.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("HELLO");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleBackToDashboard(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecurityOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("HELLO");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleNext(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlertNotifications.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("HELLO");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void Savebutton(ActionEvent actionEvent) {

        String gateName = txtGateName.getText().trim();
        String visitorCount = txtVisitorCount.getText().trim();
        String capacity = txtCapacity.getText().trim();
        String capacity1 = txtCapacity1.getText().trim();
        String capacity11 = txtCapacity11.getText().trim();


        String display = "Gate Name: " + gateName + "\n" +
                "Visitor Count: " + visitorCount + "\n" +
                "Capacity: " + capacity + "\n" +
                "Capacity1: " + capacity1 + "\n" +
                "Capacity11: " + capacity11;

        showdata.setText(display);

    }
}
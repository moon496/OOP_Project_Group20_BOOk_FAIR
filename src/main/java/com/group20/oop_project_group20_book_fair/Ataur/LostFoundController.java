package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class LostFoundController {
    @javafx.fxml.FXML
    private DatePicker datepickerlostnfound;
    @FXML
    public void initialize() {
        datepickerlostnfound.setValue(LocalDate.now());
    }
    @javafx.fxml.FXML
    private TextField visitorname;
    @javafx.fxml.FXML
    private TextField inputdetails;
    @javafx.fxml.FXML
    private TextField mobilenumber;
    @javafx.fxml.FXML
    private Label labelnostnfound;
    @javafx.fxml.FXML
    private TextField inputitemname;
    @javafx.fxml.FXML
    private TextField productname;



    @javafx.fxml.FXML
    public void backlostnfound(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlertNotifications.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("HELLO");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void savelostreport(ActionEvent actionEvent) {

        String itemName = inputitemname.getText().trim();
        String details = inputdetails.getText().trim();
        LocalDate date = datepickerlostnfound.getValue();

        String displayText = "Lost Item Report Saved:\n"
                + "Item Name: " + itemName + "\n"
                + "Details: " + details + "\n"
                + "Date: " + date.toString();

        labelnostnfound.setText(displayText);
    }

    @javafx.fxml.FXML
    public void nextlostnfound(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Emergency.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("HELLO");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void backtodashboardlostnfound(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecurityOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("HELLO");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void returnproductbutton(ActionEvent actionEvent) {
        String visitorName = visitorname.getText().trim();
        String productName = productname.getText().trim();
        String mobileNumber = mobilenumber.getText().trim();

        String displayText = "Product Return Processed:\n"
                + "Visitor Name: " + visitorName + "\n"
                + "Product Name: " + productName + "\n"
                + "Mobile Number: " + mobileNumber;

        labelnostnfound.setText(displayText);
    }
}

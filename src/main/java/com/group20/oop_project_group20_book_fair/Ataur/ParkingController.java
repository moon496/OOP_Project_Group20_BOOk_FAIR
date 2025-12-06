package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingController {

    @FXML
    private ComboBox<String> cartypecb;
    @FXML
    private TextField carnumber;
    @FXML
    private TextField exitcarnumber;
    @FXML
    private Label cardatamatchornotshowlabel;
    @FXML
    private TextField carownername;

    // List for storing parking entries
    private final List<Parking> parkingList = new ArrayList<>();

    @FXML
    public void initialize() {
        // ComboBox options
        cartypecb.getItems().addAll("Motorcycle", "Car", "Others");
    }

    @FXML
    public void backparkingmanagment(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecurityOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("HELLO");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void backtodashboardparkingmanagement(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccessControl.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("HELLO");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void nextparkingmanagement(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DailyReport.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("HELLO");
        stage.setScene(scene);
        stage.show();
    }

    // Entry button logic
    @FXML
    public void buttonentrydata(ActionEvent actionEvent) {

        String owner = carownername.getText();
        String number = carnumber.getText();
        String type = cartypecb.getValue();

        if (owner.isEmpty() || number.isEmpty() || type == null) {
            cardatamatchornotshowlabel.setText("Please fill all fields");
            return;
        }

        Parking p = new Parking(owner, number, type);
        parkingList.add(p);

        cardatamatchornotshowlabel.setText("Car Entry Added");

        carownername.clear();
        carnumber.clear();
        cartypecb.setValue(null);
    }

    // Exit button logic
    @FXML
    public void exitcarbutton(ActionEvent actionEvent) {

        String number = exitcarnumber.getText();

        boolean found = false;

        for (Parking p : parkingList) {
            if (p.getCarnumber().equals(number) && !p.isExited()) {
                p.setExited(true);
                found = true;
                break;
            }
        }

        if (found) {
            cardatamatchornotshowlabel.setText("Car Exited");
        } else {
            cardatamatchornotshowlabel.setText("Car Not Found");
        }

        exitcarnumber.clear();
    }
}

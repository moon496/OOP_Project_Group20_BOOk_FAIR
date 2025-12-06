package com.group20.oop_project_group20_book_fair;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {
    @javafx.fxml.FXML
    private PasswordField password;
    @javafx.fxml.FXML
    private ComboBox UserInput;
    @javafx.fxml.FXML
    private Label lableinfo;
    @javafx.fxml.FXML
    private CheckBox showpassword;
    @javafx.fxml.FXML
    private Label text;

    @javafx.fxml.FXML
    public void initialize() {
        UserInput.getItems().addAll("Customer", "Publisher", "Security Officer ", "Stall Manager", "Organizer", "Food Stall Manager ");

    }

    @javafx.fxml.FXML
    public void Login(ActionEvent actionEvent) throws IOException {

        if ((UserInput.getValue() == null) || (password.getText().isEmpty())) {
            lableinfo.setText("Choose user and enter password!");
            return;
        }
        if ((UserInput.getValue().equals("Customer")) && (password.getText().equals("12345"))) {
            screenSwitcher.switchTo("Moon/Customer.fxml");
        }

        if ((UserInput.getValue().equals("Publisher")) && (password.getText().equals("23456"))) {
            screenSwitcher.switchTo("Moon/Publisher.fxml");
        }
        if ((UserInput.getValue().equals("Stall Manager")) && (password.getText().equals("12345"))) {
            screenSwitcher.switchTo("Ataur/StallManagerDashboard.fxml");
        }

        if ((UserInput.getValue().equals("Security Officer")) && (password.getText().equals("12345"))) {
            screenSwitcher.switchTo("Ataur/SecurityOfficerDashboard.fxml");
        }

        else {

            lableinfo.setText("Invalid credentials");
            lableinfo.setText(" Please check your ID and password!");

        }

    }


    @javafx.fxml.FXML
    public void Showpassword(ActionEvent actionEvent) {
        if (showpassword.isSelected()){
            if (password.getText().isEmpty()){
                text.setText("Enter Password!");
                return;
            }
            text.setText(password.getText());
        } else {
            text.setText("");
        }
    }
}

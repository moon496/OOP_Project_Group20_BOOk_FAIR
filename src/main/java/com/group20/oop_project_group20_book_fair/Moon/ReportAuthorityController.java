package com.group20.oop_project_group20_book_fair.Moon;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class ReportAuthorityController
{
    @javafx.fxml.FXML
    private ComboBox <String> adminComboBox;
    @javafx.fxml.FXML
    private TextArea messageArea;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        adminComboBox.getItems().addAll("Admin1", "Admin2", "Admin3","Admin4");
    }


    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/GenerateSalesReport.fxml");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Discount&Offer.fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Publisher.fxml");
    }

    @javafx.fxml.FXML
    public void sendButton(ActionEvent actionEvent) {
        String message = messageArea.getText().trim();
        String recipient = adminComboBox.getValue();

        if (message.isEmpty() || recipient == null) {
            statusLabel.setText("Please enter a message and select a recipient.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("admin_messages.txt", true))) {
            writer.write("To: " + recipient + "\nMessage: " + message + "\n\n");
            statusLabel.setText("Message sent successfully!");
            messageArea.clear();
            adminComboBox.getSelectionModel().clearSelection();
        } catch (IOException e) {
            statusLabel.setText("Failed to send message. Try again.");
            e.printStackTrace();
        }
    }
}
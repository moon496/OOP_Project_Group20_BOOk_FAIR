package com.group20.oop_project_group20_book_fair.Moon;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class GiveFeedbackController
{
    @javafx.fxml.FXML
    private TextArea FeedbackField;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
        messageLabel.setText("");
    }



    @javafx.fxml.FXML
    public void SubmitFeedback(ActionEvent actionEvent) {
        String feedback = FeedbackField.getText().trim();

        if (feedback.isEmpty()) {
            messageLabel.setText("Feedback cannot be empty!");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }
        System.out.println("Feedback Saved: " + feedback);

        messageLabel.setText("Thank you! Your feedback has been submitted.");
        messageLabel.setStyle("-fx-text-fill: green;");

        FeedbackField.clear();
    }

    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/SeminarEvent .fxml");

    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Meet Author.fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Customer.fxml");
    }
}
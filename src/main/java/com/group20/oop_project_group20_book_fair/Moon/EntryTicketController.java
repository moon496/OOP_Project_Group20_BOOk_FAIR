package com.group20.oop_project_group20_book_fair.Moon;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class EntryTicketController
{
    @javafx.fxml.FXML
    private Label validdate;
    @javafx.fxml.FXML
    private PasswordField passfield;
    @javafx.fxml.FXML
    private TextField Numberfield;
    @javafx.fxml.FXML
    private Label viewid;
    @javafx.fxml.FXML
    private TextField Namefield;
    @javafx.fxml.FXML
    private TextField datefield;
    @javafx.fxml.FXML
    private Label Textview;
    @javafx.fxml.FXML
    private Label name;
    @javafx.fxml.FXML
    private VBox TicketBox;

    private boolean paymentValidated = false;



    @javafx.fxml.FXML
    public void initialize() {
        TicketBox.setVisible(false);


    }

    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {

        switchTo("Moon/PublisherBookBrowser.fxml");
    }

    @javafx.fxml.FXML
    public void Logout(ActionEvent actionEvent) throws IOException {
        switchTo("Login.fxml");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/SearchBookStall.fxml");

    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Customer.fxml");

    }

    @javafx.fxml.FXML
    public void ValidatePayment(ActionEvent actionEvent) {
        if (Namefield.getText().isEmpty() ||
                Numberfield.getText().isEmpty() ||
                datefield.getText().isEmpty() ||
                passfield.getText().isEmpty()) {

            Textview.setText("Please fill all payment fields!");

            paymentValidated = false;
            return;
        }
        if (Numberfield.getText().length() < 14) {
            Textview.setText("Invalid card number!");

            paymentValidated = false;
            return;
        }
        if (passfield.getText().length() != 3) {
            Textview.setText("Invalid CVV!");

            paymentValidated = false;
            return;
        }
        Textview.setText("Payment Validated Successfully!");

        paymentValidated = true;

    }

    @javafx.fxml.FXML
    public void BuyTicket(ActionEvent actionEvent) {
        if (!paymentValidated) {
            Textview.setText("Please validate payment first!");

            return;
        }
        Random random = new Random();
        int id = 100000 + random.nextInt(900000);
        viewid.setText("View ID : " + id);


        LocalDate valid = LocalDate.now().plusDays(1);
        validdate.setText("Valid Date : " + valid);


        name.setText("Name : " + Namefield.getText());


        TicketBox.setVisible(true);

        Textview.setText("Ticket Generated Successfully!");

    }
}
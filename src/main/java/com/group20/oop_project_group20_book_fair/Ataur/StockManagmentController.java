package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class StockManagmentController
{
    @javafx.fxml.FXML
    private TextField  mobilenumber;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TextField customername;
    @javafx.fxml.FXML
    private TextField bookname;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void previoussm(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/NewSale.fxml");
    }

    @javafx.fxml.FXML
    public void nextsm(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/SalesReport.fxml");
    }

    @javafx.fxml.FXML
    public void backtodashboardsm(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StallManagerDashboard.fxml");
    }

        @javafx.fxml.FXML
        public void addtowhitelist(ActionEvent actionEvent) {

            String name = customername.getText();
            String mobile = mobilenumber.getText();
            String book = bookname.getText();


            if (name.isEmpty()) {
                label.setText("Enter customer name!");
                return;
            }

            if (mobile.isEmpty()) {
                label.setText("Enter mobile number!");
                return;
            }

            if (!mobile.matches("\\d{10,11}")) {
                label.setText("Invalid mobile number!");
                return;
            }

            if (book.isEmpty()) {
                label.setText("Enter book name!");
                return;
            }

            // If everything is valid
            label.setText("Added to WhiteList → Name: " + name + ", Mobile: " + mobile + ", Book: " + book);
        }


    }


package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class DiscountsCornerController
{
    @javafx.fxml.FXML
    private TextField applydiscount;

    @javafx.fxml.FXML
    private ComboBox<String> booklistCB;

    @javafx.fxml.FXML
    private TextField currentprice;

    @javafx.fxml.FXML
    private Label showdiscountedprice;

    @javafx.fxml.FXML
    public void initialize() {
        booklistCB.getItems().addAll("Book 1", "Book 2", "Book 3");
        booklistCB.getSelectionModel().selectFirst();

    }

    @javafx.fxml.FXML
    public void applydiscountbutton(ActionEvent actionEvent) {
        String priceText = currentprice.getText();
        String discountText = applydiscount.getText();

        if (priceText.isEmpty() || discountText.isEmpty()) {
            showdiscountedprice.setText("Input Missing");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            double discount = Double.parseDouble(discountText);

            double discountedPrice = price - (price * (discount / 100));
            showdiscountedprice.setText("Discounted Price: " + discountedPrice);
        } catch (NumberFormatException e) {
            showdiscountedprice.setText("Invalid Input");
        }


    }

    @javafx.fxml.FXML
    public void previousdc(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/SalesReport.fxml");
    }

    @javafx.fxml.FXML
    public void backtodashboarddc(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StallManagerDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void nextdc(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StallManagerDayReport.fxml");
    }
}

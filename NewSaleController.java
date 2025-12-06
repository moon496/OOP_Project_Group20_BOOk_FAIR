package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class NewSaleController
{
    @javafx.fxml.FXML
    private TextField quantitynewsale;
    @javafx.fxml.FXML
    private Label labelnewsale;
    @javafx.fxml.FXML
    private ComboBox comboxCBnewsale;


    @javafx.fxml.FXML
    public void initialize() {

        comboxCBnewsale.getItems().setAll("Fiction", "Non Fiction", "Academic");
        labelnewsale.setText("New Sale");
    }

    private void loadCart() {
    }

    @javafx.fxml.FXML
    public void nextnewsale(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StockManagement.fxml");
    }

    @javafx.fxml.FXML
    public void previousnewsale(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/AddBook.fxml");
    }

    @javafx.fxml.FXML
    public void backtodashboardnewsale(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StallManagerDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void addtocart(ActionEvent actionEvent) {

        String category = comboxCBnewsale.getValue().toString();
        String quantityText = quantitynewsale.getText();


        if (category == null || category.isEmpty()) {
            labelnewsale.setText("Select a category first!");
            return;
        }

        if (quantityText.isEmpty()) {
            labelnewsale.setText("Enter quantity!");
            return;
        }

        int quantity;

        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            labelnewsale.setText("Invalid quantity!");
            return;
        }


        labelnewsale.setText("Added to Cart → Category: " + category + ", Qty: " + quantity);
    }

}
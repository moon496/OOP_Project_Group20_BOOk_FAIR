package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class AddBookController
{
    @javafx.fxml.FXML
    private ComboBox <String> bookcatagorycb;
    @javafx.fxml.FXML
    private TextField addauthorname;
    @javafx.fxml.FXML
    private TextField addprice;
    @javafx.fxml.FXML
    private TextField addbookname;
    @javafx.fxml.FXML
    private Label showinputdata;

    @javafx.fxml.FXML
    public void initialize() {
        bookcatagorycb.getItems().setAll("Fiction", "Non Fiction", "Science", "History", "Academic");

    }

    @javafx.fxml.FXML
    public void savebutton(ActionEvent actionEvent) {
        String category = bookcatagorycb.getValue();
        String bookName = addbookname.getText();
        String author = addauthorname.getText();
        String price = addprice.getText();

        if (category == null || category.isEmpty()) {
            showinputdata.setText("Select a category!");
            return;
        }

        if (bookName.isEmpty() || author.isEmpty() || price.isEmpty()) {
            showinputdata.setText("Fill all fields!");
            return;
        }
        showinputdata.setText(
                "Saved → " +
                        "Category: " + category +
                        ", Book: " + bookName +
                        ", Author: " + author +
                        ", Price: " + price
        );

    }

    @javafx.fxml.FXML
    public void plusbutton(ActionEvent actionEvent) {
        String value = addprice.getText();

        if (value.isEmpty()) {
            addprice.setText("1");
            return;
        }

        try {
            int price = Integer.parseInt(value);
            price++;
            addprice.setText(String.valueOf(price));
        } catch (NumberFormatException e) {
            showinputdata.setText("Invalid price number!");
        }
    }

    @javafx.fxml.FXML
    public void backtodashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StallManagerDashboard.fxml");
    }


    @javafx.fxml.FXML
    public void nextbutton(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/NewSale.fxml");
    }

    @javafx.fxml.FXML
    public void resetbutton(ActionEvent actionEvent) {
        bookcatagorycb.setValue(null);
        addbookname.clear();
        addauthorname.clear();
        addprice.clear();
        showinputdata.setText("");
    }

    @javafx.fxml.FXML
    public void previousbutton(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/ViewInventory.fxml");
    }

    @javafx.fxml.FXML
    public void minusbutton(ActionEvent actionEvent) {
        String value = addprice.getText();

        if (value.isEmpty()) {
            return;
        }

        try {
            int price = Integer.parseInt(value);
            if (price > 0) price--;
            addprice.setText(String.valueOf(price));
        } catch (NumberFormatException e) {
            showinputdata.setText("Invalid price number!");
        }
    }
}

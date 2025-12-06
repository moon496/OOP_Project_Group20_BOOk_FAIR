package com.group20.oop_project_group20_book_fair.Moon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class DiscountAndOfferController
{
    @javafx.fxml.FXML
    private ComboBox <String> BookCombo;
    @javafx.fxml.FXML
    private TextField Discount;
    @javafx.fxml.FXML
    private DatePicker endDate;
    @javafx.fxml.FXML
    private TextField NameField;
    @javafx.fxml.FXML
    private DatePicker startdate;
    @javafx.fxml.FXML
    private Label statusLabel;
    private ObservableList<Object> promotions = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        BookCombo.setItems(FXCollections.observableArrayList("All Books", "Book A", "Book B", "Book C"));
        BookCombo.getSelectionModel().select(0);
    }

    @javafx.fxml.FXML
    public void AddPromotion(ActionEvent actionEvent) {
        String name = NameField.getText().trim();
        String book = BookCombo.getValue();
        String discountText = Discount.getText().trim();
        LocalDate start = startdate.getValue();
        LocalDate end = endDate.getValue();


        if (name.isEmpty() || discountText.isEmpty() || start == null || end == null) {
            statusLabel.setText("Please fill all fields!");
            return;
        }
        double discountValue;
        try {
            discountValue = Double.parseDouble(discountText);
            if (discountValue <= 0 || discountValue > 100) {
                statusLabel.setText("Discount must be between 0 and 100!");
                return;
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid discount value!");
            return;
        }

        if (end.isBefore(start)) {
            statusLabel.setText("End date cannot be before start date!");
            return;
        }
        promotions.add(new Promotion(name, book, discountValue, start, end));
        statusLabel.setText("Promotion added successfully!");
        Reset(null);

    }

    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/ReportAuthority.fxml");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/SalesRecords.fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Publisher.fxml");
    }

    @javafx.fxml.FXML
    public void Reset(ActionEvent actionEvent) {
        NameField.clear();
        Discount.clear();
        startdate.setValue(null);
        endDate.setValue(null);
        BookCombo.getSelectionModel().select(0);
    }
}
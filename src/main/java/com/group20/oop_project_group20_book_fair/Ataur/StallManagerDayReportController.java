package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class StallManagerDayReportController
{
    @javafx.fxml.FXML
    private Label showdata;
    @javafx.fxml.FXML
    private TextField outofstockbooks;
    @javafx.fxml.FXML
    private TextField totalsalebooks;
    @javafx.fxml.FXML
    private TextField mostsellingbooks;
    @javafx.fxml.FXML
    private DatePicker datepicker;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void previous(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/DiscountsCorner.fxml");
    }

    @javafx.fxml.FXML
    public void backtodashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StallManagerDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void save(ActionEvent actionEvent) {

            LocalDate date = datepicker.getValue();


            String totalSale = totalsalebooks.getText();
            String outOfStock = outofstockbooks.getText();
            String mostSelling = mostsellingbooks.getText();


            showdata.setText(
                    "Date: " + (date != null ? date.toString() : "Not selected") +
                            "\nTotal Sale Books: " + totalSale +
                            "\nOut of Stock Books: " + outOfStock +
                            "\nMost Selling Books: " + mostSelling
            );


            totalsalebooks.clear();
            outofstockbooks.clear();
            mostsellingbooks.clear();
            datepicker.setValue(null);
        }


    }


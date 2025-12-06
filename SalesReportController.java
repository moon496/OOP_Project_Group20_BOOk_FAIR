package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class SalesReportController
{
    @FXML
    private DatePicker datepickersr;
    @FXML
    private TextField label;
    @FXML
    private TextField totalsalesr;
    @FXML
    private TableColumn <SalesReport, LocalDate> dateCol;
    @FXML
    private TableColumn <SalesReport, Integer> SaleCol;
    @FXML
    private TableView <SalesReport>tableView;
    @FXML
    private PieChart pieChart;

    @FXML
    public void initialize() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        SaleCol.setCellValueFactory(new PropertyValueFactory<>("totalsale"));


        pieChart.getData().clear();

        tableView.getItems().add(new SalesReport(LocalDate.of(2025, 12, 1), 50, "Book A"));
        tableView.getItems().add(new SalesReport(LocalDate.of(2025, 12, 2), 30, "Book B"));
        tableView.getItems().add(new SalesReport(LocalDate.of(2025, 12, 3), 70, "Book C"));

        pieChart.getData().add(new PieChart.Data("Book A", 50));
        pieChart.getData().add(new PieChart.Data("Book B", 30));
        pieChart.getData().add(new PieChart.Data("Book C", 70));



    }

    @FXML
    public void backtodashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StallManagerDashboard.fxml");
    }

    @FXML
    public void nextsalereportbutton(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/DiscountsCorner.fxml");
    }

    @FXML
    public void previoussrbutton(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StockManagement.fxml");
    }

    @FXML
    public void showreport(ActionEvent actionEvent) {
        if (datepickersr.getValue() == null) {
            System.out.println("Please Select the date!");
            return;
        }

        String itemName = label.getText();
        String salesText = totalsalesr.getText();



        if (itemName.isEmpty() || salesText.isEmpty()) {
            System.out.println("Please enter the information");
            return;
        }

        try {
            int salesValue = Integer.parseInt(salesText);
            LocalDate selectedDate = datepickersr.getValue();

            // SalesReport object
            SalesReport report = new SalesReport(selectedDate, salesValue, itemName);

            // TableView update
            tableView.getItems().add(report);

            // PieChart update
            pieChart.getData().add(new PieChart.Data(report.getLabelText(), report.getTotalsale()));

        } catch (NumberFormatException e) {
            System.out.println("Please provide a valid sales number");
        }
    }

}


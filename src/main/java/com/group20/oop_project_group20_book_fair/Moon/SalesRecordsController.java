package com.group20.oop_project_group20_book_fair.Moon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class SalesRecordsController
{
    @javafx.fxml.FXML
    private TableColumn <SaleRecord, String> catagorycol;
    @javafx.fxml.FXML
    private TableColumn<SaleRecord, String> datecol;
    @javafx.fxml.FXML
    private DatePicker fromDatepicker;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn <SaleRecord, String>quantitycol;
    @javafx.fxml.FXML
    private Label statusLable;
    @javafx.fxml.FXML
    private ComboBox <String>filterComboBox;
    @javafx.fxml.FXML
    private TableView <SaleRecord>Tableview;
    @javafx.fxml.FXML
    private TableColumn <SaleRecord, String> bookcol;
    @javafx.fxml.FXML
    private TableColumn <SaleRecord, String> salecol;
    @javafx.fxml.FXML
    private TextField totalSale;
    @javafx.fxml.FXML
    private PieChart pieChart;
    private ObservableList<SaleRecord> salesData = FXCollections.observableArrayList();
    private static final String SALES_DATA_FILE = "sales_data.txt";


    @javafx.fxml.FXML
    public void initialize() {
        filterComboBox.setItems(FXCollections.observableArrayList("All Books", "Category 1", "Fiction", "Non-Fiction","Science","History","Technology","Children's Books", "Category 2" ,"Biography"));
        filterComboBox.getSelectionModel().select(0);
        salesData.addAll(
                new SaleRecord("Book A", "Category 1", 10, 500.0, "2025-12-01"),
                new SaleRecord("Book B", "Category 2", 5, 250.0, "2025-12-02"),
                new SaleRecord("Book C", "Category 1", 8, 400.0, "2025-12-03"),

                new SaleRecord("Harry Potter and the Philosopher's Stone", "Fiction", 15, 750.0, "2025-11-01"),
                new SaleRecord("The Great Gatsby", "Fiction", 12, 480.0, "2025-11-02"),
                new SaleRecord("1984", "Fiction", 20, 1000.0, "2025-11-08"),


                new SaleRecord("Atomic Habits", "Non-Fiction", 30, 1800.0, "2025-11-11"),
                new SaleRecord("Think and Grow Rich", "Non-Fiction", 12, 480.0, "2025-11-14"),

                new SaleRecord("A Brief History of Time", "Science", 11, 660.0, "2025-11-04"),
                new SaleRecord("The Selfish Gene", "Science", 9, 450.0, "2025-11-07"),
                new SaleRecord("Cosmos", "Science", 13, 780.0, "2025-11-13"),
                new SaleRecord("The Origin of Species", "Science", 7, 350.0, "2025-11-16"),

                new SaleRecord("Guns, Germs, and Steel", "History", 10, 500.0, "2025-11-19"),
                new SaleRecord("The Silk Roads", "History", 8, 480.0, "2025-11-21"),
                new SaleRecord("A People's History", "History", 12, 600.0, "2025-11-23"),


                new SaleRecord("Design Patterns", "Technology", 18, 1440.0, "2025-11-24"),
                new SaleRecord("The Pragmatic Programmer", "Technology", 16, 1120.0, "2025-11-25"),


                new SaleRecord("Charlotte's Web", "Children's Books", 25, 750.0, "2025-11-30"),

                new SaleRecord("Unbroken", "Biography", 15, 900.0, "2025-12-05")
        );


        bookcol.setCellValueFactory(cellData -> cellData.getValue().bookNameProperty());
        catagorycol.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        quantitycol.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject().asString());
        salecol.setCellValueFactory(cellData -> cellData.getValue().saleAmountProperty().asObject().asString());
        datecol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        Tableview.setItems(salesData);
        calculateTotalSales();
        populatePieChart();

        saveSalesDataToFile();
    }

    private void saveSalesDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SALES_DATA_FILE))) {

            writer.println("Date,BookTitle,Quantity,Price,Total");


            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            for (SaleRecord record : salesData) {

                LocalDate date = LocalDate.parse(record.getDate(), inputFormat);
                String formattedDate = date.format(outputFormat);


                double price = record.getSaleAmount() / record.getQuantity();

                writer.println(String.format("%s,%s,%d,%.2f,%.2f",
                        formattedDate,
                        record.getBookName(),
                        record.getQuantity(),
                        price,
                        record.getSaleAmount()
                ));

            }
            System.out.println("Sales data saved to file successfully!");
        } catch (IOException e) {
            System.err.println("Error saving sales data: " + e.getMessage());
        }

        }


    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Discount&Offer.fxml");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/ManageStallBooking.fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Publisher.fxml");
    }

    @javafx.fxml.FXML
    public void GenerateReport(ActionEvent actionEvent) {

        saveSalesDataToFile();
        statusLable.setText("Report generated successfully!");
    String filter = filterComboBox.getValue();
        ObservableList<SaleRecord> filtered = FXCollections.observableArrayList();
        for (SaleRecord s : salesData) {
            if (filter.equals("All Books") || s.getCategory().equals(filter)) {
                filtered.add(s);
            }
        }
        Tableview.setItems(filtered);

        calculateTotalSales();
        populatePieChart();
        statusLable.setText("Report generated successfully!");
    }
    
    private void calculateTotalSales() {
        double total = 0;
        for (SaleRecord s : Tableview.getItems()) {
            total += s.getSaleAmount();
        }
        totalSale.setText(String.valueOf(total));
    }
    private void populatePieChart() {
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
        for (SaleRecord s : Tableview.getItems()) {
            pieData.add(new PieChart.Data(s.getBookName(), s.getSaleAmount()));
        }
        pieChart.setData(pieData);
    }

}

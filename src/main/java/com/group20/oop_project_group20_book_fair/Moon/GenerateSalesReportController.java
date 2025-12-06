package com.group20.oop_project_group20_book_fair.Moon;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class GenerateSalesReportController
{
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;

    @javafx.fxml.FXML
    private TextArea reportPreviewArea;

    @javafx.fxml.FXML
    private Label statusLabel;

    private static final String SALES_DATA_FILE = "sales_data.txt";
    private static final DateTimeFormatter FILE_DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @javafx.fxml.FXML
    public void initialize() {
        statusLabel.setText("");
    }


    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/OrganizeEvents.fxml");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/ReportAuthority.fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Publisher.fxml");
    }



    @javafx.fxml.FXML
    public void generateReportButton(ActionEvent actionEvent) {

        LocalDate selectedDate = reportDatePicker.getValue();

        if (selectedDate == null) {
            statusLabel.setText("Please select a date!");
            return;
        }


        String formattedDate = selectedDate.format(FILE_DATE_FORMAT);

        StringBuilder report = new StringBuilder();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(SALES_DATA_FILE))) {

            String line = br.readLine();

            report.append("Sales Report for ").append(formattedDate).append("\n\n");

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length < 5) continue;

                String fileDate = parts[0];

                if (fileDate.equals(formattedDate)) {

                    report.append("Date: ").append(parts[0]).append("\n");
                    report.append("Book Title: ").append(parts[1]).append("\n");
                    report.append("Quantity: ").append(parts[2]).append("\n");
                    report.append("Price: ").append(parts[3]).append("\n");
                    report.append("Total: ").append(parts[4]).append("\n");
                    report.append("-----------------------------------------\n");

                    found = true;
                }
            }

            if (!found) {
                reportPreviewArea.setText("No sales found for this date.");
                statusLabel.setText("No records found.");
            } else {
                reportPreviewArea.setText(report.toString());
                statusLabel.setText("Report generated successfully.");
            }

        } catch (Exception e) {
            statusLabel.setText("Error reading sales_data.txt!");
        }
    }


    @javafx.fxml.FXML
    public void downloadPdfButton(ActionEvent actionEvent) {

        if (reportPreviewArea.getText().isEmpty()) {
            statusLabel.setText("Generate a report first!");
            return;
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("sales_report.txt"))) {

            pw.println(reportPreviewArea.getText());
            statusLabel.setText("Report saved as sales_report.txt");

        } catch (Exception e) {
            statusLabel.setText("Error saving report!");
        }
    }
}

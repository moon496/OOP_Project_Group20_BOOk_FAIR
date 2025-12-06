package com.group20.oop_project_group20_book_fair.Moon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert.AlertType;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;
import static jdk.jfr.FlightRecorder.isAvailable;

public class ManageStallBookingController
{
    @javafx.fxml.FXML
    private Label statusText;
    @javafx.fxml.FXML
    private DatePicker FromDate;
    @javafx.fxml.FXML
    private DatePicker ToDate;
    @javafx.fxml.FXML
    private ComboBox <String> stallbox;

    private final String BOOKING_FILE = "stall_bookings.txt";


    @FXML
    public void initialize() {
        stallbox.getItems().addAll("Stall 1", "Stall 2", "Stall 3", "Stall 4");

        if (stallbox.getValue() == null || FromDate.getValue() == null || ToDate.getValue() == null) {
            statusText.setText("Please fill all fields!");
            return;
        }

        String stall = stallbox.getValue();
        LocalDate from = FromDate.getValue();
        LocalDate to = ToDate.getValue();
        
        if (to.isBefore(from)) {
            statusText.setText("End date must be after start date!");
            return;
        }
        if (!isAvailable(stall, from, to)) {
            statusText.setText("Stall not available for selected dates!");
            return;
        }
        try (FileWriter fw = new FileWriter(BOOKING_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(stall + "," + from + "," + to);
            bw.newLine();
            statusText.setText("Booking successful!");
            wait("Success", "Stall booked successfully!", AlertType.INFORMATION);
        } catch (IOException e) {
            statusText.setText("Error saving booking!");
            e.printStackTrace();
        }

    }

    private void wait(String success, String s, AlertType alertType) {
    }

    private boolean isAvailable(String stall, LocalDate from, LocalDate to) {
        List<String> bookings = readBookings();

        for (String booking : bookings) {
            String[] parts = booking.split(",");
            if (parts.length != 3) continue;

            String bookedStall = parts[0];
            LocalDate bookedFrom = LocalDate.parse(parts[1]);
            LocalDate bookedTo = LocalDate.parse(parts[2]);
            if (bookedStall.equals(stall)) {
                if (!(to.isBefore(bookedFrom) || from.isAfter(bookedTo))) {
                    return false; // Overlap found
                }
            }
        }
        return true;
    }
    private List<String> readBookings() {
        List<String> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKING_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                bookings.add(line);
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, return empty list
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookings;
    }
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/SalesRecords.fxml");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Registerpublisherprofile.fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Publisher.fxml");
    }

    @javafx.fxml.FXML
    public void BookStall(ActionEvent actionEvent) {
        if (stallbox.getValue() == null || FromDate.getValue() == null || ToDate.getValue() == null) {
            statusText.setText("Please fill all fields!");
            return;
        }
        String stall = stallbox.getValue();
        LocalDate from = FromDate.getValue();
        LocalDate to = ToDate.getValue();

        if (to.isBefore(from)) {
            statusText.setText("End date must be after start date!");
            return;
        }
        if (!isAvailable(stall, from, to)) {
            statusText.setText("Stall not available for selected dates!");
            return;
        }
        try (FileWriter fw = new FileWriter(BOOKING_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(stall + "," + from + "," + to);
            bw.newLine();
            statusText.setText("Booking successful!");
            showAlert("Success", "Stall booked successfully!", AlertType.INFORMATION);
        } catch (IOException e) {
            statusText.setText("Error saving booking!");
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void CheckAvailability(ActionEvent actionEvent) {
        if (stallbox.getValue() == null || FromDate.getValue() == null || ToDate.getValue() == null) {
            statusText.setText("Please fill all fields!");
            return;
        }

        String stall = stallbox.getValue();
        LocalDate from = FromDate.getValue();
        LocalDate to = ToDate.getValue();

        if (isAvailable(stall, from, to)) {
            statusText.setText("Stall is available!");
        } else {
            statusText.setText("Stall is NOT available!");
        }
    }

}
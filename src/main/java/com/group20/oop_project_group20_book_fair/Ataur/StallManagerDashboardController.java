package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class StallManagerDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    public void next(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchScreen("Ataur/ViewInventory.fxml");
    }

    @FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchScreen("Login.fxml");
    }

    @javafx.fxml.FXML
    public void viewinventory(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/ViewInventory.fxml");
    }

    @javafx.fxml.FXML
    public void managediscounts(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/DiscountsCorner.fxml");
    }

    @javafx.fxml.FXML
    public void stockmanagement(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StockManagement.fxml");
    }

    @javafx.fxml.FXML
    public void addbook(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/AddBook.fxml");
    }

    @javafx.fxml.FXML
    public void dayreport(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StallManagerDayReport.fxml");
    }

    @javafx.fxml.FXML
    public void newsale(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/NewSale.fxml");
    }
    @javafx.fxml.FXML
    public void salesreport(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/SalesReport.fxml");
    }
}
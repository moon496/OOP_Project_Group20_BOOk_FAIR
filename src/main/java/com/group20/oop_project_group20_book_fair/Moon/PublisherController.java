package com.group20.oop_project_group20_book_fair.Moon;

import com.group20.oop_project_group20_book_fair.screenSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class PublisherController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("Login.fxml");
    }


    @javafx.fxml.FXML
    public void Discount(ActionEvent actionEvent) throws IOException{
        screenSwitcher.switchTo("Moon/DiscountAndOffer.fxml");
    }

    @javafx.fxml.FXML
    public void SalesRecords(ActionEvent actionEvent) throws IOException{
        screenSwitcher.switchTo("Moon/SalesRecords.fxml");
    }

    @javafx.fxml.FXML
    public void BookList(ActionEvent actionEvent) throws IOException{
        screenSwitcher.switchTo("Moon/BookList.fxml");
    }

    @javafx.fxml.FXML
    public void Popularity(ActionEvent actionEvent) throws IOException{
        screenSwitcher.switchTo("Moon/TrackBookPopularity.fxml");
    }

    @javafx.fxml.FXML
    public void StallBooking(ActionEvent actionEvent) throws IOException{
        screenSwitcher.switchTo("Moon/ManageStallBooking.fxml");
    }

    @javafx.fxml.FXML
    public void reportAuthority(ActionEvent actionEvent) throws IOException{
        screenSwitcher.switchTo("Moon/ReportAuthority.fxml");
    }

    @javafx.fxml.FXML
    public void SalesReport(ActionEvent actionEvent) throws IOException{
        screenSwitcher.switchTo("Moon/SalesRecords.fxml");
    }

    @javafx.fxml.FXML
    public void RegisterPublisherProfile(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("Moon/Registerpublisherprofile.fxml");
    }
}
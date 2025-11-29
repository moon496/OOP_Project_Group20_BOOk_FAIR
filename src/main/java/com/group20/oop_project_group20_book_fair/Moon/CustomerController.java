package com.group20.oop_project_group20_book_fair.Moon;

import com.group20.oop_project_group20_book_fair.screenSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class CustomerController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void givefeedback(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/GiveFeedback.fxml");
    }

    @javafx.fxml.FXML
    public void meetAuthor(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/MeetAuthor.fxml");
    }

    @javafx.fxml.FXML
    public void seminarTime(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/EventTime.fxml");
    }

    @javafx.fxml.FXML
    public void wishlistCollection(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/WishListCollection.fxml");
    }

    @javafx.fxml.FXML
    public void complain(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Complain.fxml");
    }

    @javafx.fxml.FXML
    public void searchbookstall(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/SearchBookStall.fxml");
    }

    @javafx.fxml.FXML
    public void publisherBook(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/PublisherBookBrowser.fxml");
    }

    @javafx.fxml.FXML
    public void entryTicket(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/EntryTicket.fxml");
    }



    @javafx.fxml.FXML
    public void Logout(ActionEvent actionEvent) throws IOException {
        switchTo("Login.fxml");
    }


}
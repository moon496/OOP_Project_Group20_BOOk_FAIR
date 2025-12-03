package com.group20.oop_project_group20_book_fair.Moon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class WishListCollectionController
{
    @javafx.fxml.FXML
    private TableColumn <WishlistModel , String>titleCol;
    @javafx.fxml.FXML
    private TableView < WishlistModel > wishlistTable;
    @javafx.fxml.FXML
    private TableColumn <WishlistModel , String> catagoryCol;
    @javafx.fxml.FXML
    private TableColumn<WishlistModel , String>authorCol;
    @javafx.fxml.FXML
    private Label textView;
    @javafx.fxml.FXML
    private ComboBox <String> bookComboBox;
    @javafx.fxml.FXML
    private TableColumn <WishlistModel , String> priceCol;

    ObservableList<WishlistModel> wishlistdata = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TextField author;
    @javafx.fxml.FXML
    private TextField price;
    @javafx.fxml.FXML
    private TextField category;

    @javafx.fxml.FXML
    public void initialize() {
        bookComboBox.getItems().addAll("Atomic Habits", "Harry Potter","The Alchemist","Rich Dad Poor Dad","Clean Code","Deep Work","The Power of Habit"," shesher  Porichoy");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        catagoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        wishlistTable.setItems(wishlistdata);
    }

    @javafx.fxml.FXML
    public void AddToWishlist(ActionEvent actionEvent) {
        String selectedBook = bookComboBox.getValue();


        if (selectedBook == null) {
            textView.setText("Please select a book!");
            textView.setStyle("-fx-text-fill: red;");
            return;
        }
        String authorName = "";
        String categoryName = "";
        String priceValue = "";

        switch (selectedBook) {
            case "Atomic Habits":
                authorName = "James Clear";
                categoryName = "Self-help";
                priceValue = "450 Tk";
                break;

            case "Harry Potter":
                authorName = "J.K. Rowling";
                categoryName = "Fantasy";
                priceValue = "550 Tk";
                break;

            case "The Alchemist":
                authorName= "Paulo Coelho";
                categoryName  = "Novel";
                priceValue= "320 Tk";
                break;

            case "Rich Dad Poor Dad":
                authorName = "Robert Kiyosaki";
                categoryName  = "Finance";
                priceValue= "380 Tk";
                break;

            case "Clean Code":
                authorName = "Robert C. Martin";
                categoryName  = "Programming";
                priceValue = "600 Tk";
                break;
            case "Deep Work":
                authorName = "Cal Newport";
                categoryName  = "Productivity";
                priceValue= "500 Tk";
                break;
            case "The Power of Habit":
                authorName = "Charles Duhigg";
                categoryName  = "Self-help";
                priceValue= "450 Tk";
                break;

            case " shesher  Porichoy":
                authorName = "Sarat Chandra Chattopadhyay";
                categoryName  = "nobel";
                priceValue= "450 Tk";
                break;

        }
        this.author.setText(authorName);
        this.category.setText(categoryName);
        this.price.setText(priceValue);

        wishlistdata.add(new WishlistModel(selectedBook, authorName, categoryName, priceValue));
        textView.setText("Book added to wishlist!");
        bookComboBox.getSelectionModel().clearSelection();
}

    @javafx.fxml.FXML
    public void BackPage(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/PublisherBookBrowser.fxml");


    }

    @javafx.fxml.FXML
    public void CustomerDashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Customer.fxml");
    }

    @javafx.fxml.FXML
    public void NextPage(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Meet Author.fxml");
    }
}
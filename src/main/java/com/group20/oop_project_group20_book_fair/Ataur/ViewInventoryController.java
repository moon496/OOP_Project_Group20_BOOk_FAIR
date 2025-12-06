package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;


public class ViewInventoryController{

  
    @FXML
    private TableView <ViewInventory> inventoryTable;
    @FXML
    private Label showDataLabel;
    @FXML
    private TableColumn <ViewInventory , String>  bookNameColumn;
    @FXML
    private TableColumn <ViewInventory , String> authorColumn;
    @FXML
    private TableColumn <ViewInventory , String> categoryColumn;
    @FXML
    private TextField searchBooksField;

    private List<ViewInventory> books = new ArrayList<>();
    @FXML
    private AnchorPane viewinventory;


    @FXML
    public void initialize() {
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        loadBooks();
        inventoryTable.getItems().setAll(books);

    }

    private void loadBooks() {
        books.add(new ViewInventory("Atomic Habits", "James Clear", "Self Development"));
        books.add(new ViewInventory("Harry Potter", "J.K. Rowling", "Fiction"));
        books.add(new ViewInventory("Clean Code", "Robert Martin", "Programming"));
        books.add(new ViewInventory("Think and Grow Rich", "Napoleon Hill", "Business"));
        books.add(new ViewInventory("Book A", "ABC", "Business"));
    }

        @FXML
    public void clickToShowResult(ActionEvent actionEvent) {
            String keyword = searchBooksField.getText().toLowerCase().trim();

            if (keyword.isEmpty()) {
                inventoryTable.getItems().setAll(books);
                showDataLabel.setText("Showing all books");
                return;
            }
            List<ViewInventory> filtered =
                    books.stream()
                            .filter(b -> b.getBookName().toLowerCase().contains(keyword))
                            .collect(Collectors.toList());

            if (filtered.isEmpty()) {
                showDataLabel.setText("No books found.");
            } else {
                showDataLabel.setText(filtered.size() + " book(s) found.");
            }

            inventoryTable.getItems().setAll(filtered);
        }






    @FXML
    public void stallManagerView(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/StallManagerDashboard.fxml");
    }

    @FXML
    public void nextAddNewBook(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/AddBook.fxml");
    }

    @FXML
    public void previousView(ActionEvent actionEvent) throws IOException {
        switchTo("Login.fxml");

    }
}

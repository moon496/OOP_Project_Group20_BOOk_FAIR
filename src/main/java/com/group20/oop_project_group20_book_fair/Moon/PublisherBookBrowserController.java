package com.group20.oop_project_group20_book_fair.Moon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class PublisherBookBrowserController {

    @FXML
    private TableColumn<Book, String> AuthorCol2;
    @FXML
    private TextField Namefield;
    @FXML
    private TableColumn<Book, String> BookCOl1;
    @FXML
    private TextField Addfield;
    @FXML
    private TableColumn<Book, Double> PriceCol3;
    @FXML
    private Label textView;
    @FXML
    private TextField Confield;
    @FXML
    private TableView<Book> TableView;
    @FXML
    private ComboBox<String> ComboBox;

    private final ObservableList<Book> bookList = FXCollections.observableArrayList();
    private final String FILE_NAME = "publisherData.txt";
    private List<Regipublisher> registeredPublishers = new ArrayList<>();

    @FXML
    public void initialize() {

        loadRegisteredPublishers();


        ObservableList<String> publisherNames = FXCollections.observableArrayList();
        for (Regipublisher pub : registeredPublishers) {
            publisherNames.add(pub.getPublisherName());
        }

        publisherNames.addAll("Penguin Books", "Pearson", "O'Reilly Media",
                "Oxford Press", "Cambridge University Press", "HarperCollins");

        ComboBox.setItems(publisherNames);

        BookCOl1.setCellValueFactory(c -> c.getValue().bookProperty());
        AuthorCol2.setCellValueFactory(c -> c.getValue().authorProperty());
        PriceCol3.setCellValueFactory(c -> c.getValue().priceProperty().asObject());

        TableView.setItems(bookList);
        textView.setText("");
    }

    private void loadRegisteredPublishers() {
        registeredPublishers.clear();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No publisher data file found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    String name = data[0].trim();
                    String address = data[2].trim();
                    String contact = data[3].trim();

                    registeredPublishers.add(new Regipublisher(name, address, contact));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading publisher data: " + e.getMessage());
        }
    }

    @FXML
    void BrowseBook(ActionEvent event) {
        String selected = ComboBox.getValue();

        if (selected == null) {
            textView.setText("❗ Please select a publisher first.");
            return;
        }

        bookList.clear();

        Regipublisher selectedPublisher = findPublisher(selected);

        if (selectedPublisher != null) {

            Namefield.setText(selectedPublisher.getPublisherName());
            Addfield.setText(selectedPublisher.getAddress());
            Confield.setText(selectedPublisher.getContact());

            bookList.addAll(
                    new Book("Sample Book 1", "Author", 500),
                    new Book("Sample Book 2", "Author", 600)
            );
            textView.setText("Showing books from registered publisher!");
        }

        else {
            Namefield.setText(selected);
            Addfield.setText("Dhaka, Bangladesh");
            Confield.setText("01234-567890");

            if (selected.equals("Penguin Books")) {
                bookList.addAll(
                        new Book("The Fault in Our Stars", "John Green", 450),
                        new Book("1984", "George Orwell", 350)
                );
            } else if (selected.equals("O'Reilly Media")) {
                bookList.addAll(
                        new Book("Learning Python", "Mark Lutz", 800),
                        new Book("Fluent Python", "Luciano Ramalho", 950)
                );
            } else if (selected.equals("HarperCollins")) {
                bookList.addAll(
                        new Book("The Alchemist", "Paulo Coelho", 450),
                        new Book("Brave New World", "Aldous Huxley", 400),
                        new Book("American Gods", "Neil Gaiman", 480)
                );
            } else if (selected.equals("Oxford Press")) {
                bookList.addAll(
                        new Book("Oxford English Dictionary", "OUP Editors", 1500),
                        new Book("The Oxford Book of Essays", "John Gross", 900)
                );
            } else if (selected.equals("Cambridge University Press")) {
                bookList.addAll(
                        new Book("Cambridge IELTS 17", "Cambridge", 650),
                        new Book("Essential Grammar in Use", "Raymond Murphy", 700),
                        new Book("Cambridge Advanced Vocabulary", "Cambridge", 550)
                );
            }
            else {
                bookList.add(new Book("No Books Found", "-", 0));
            }
            textView.setText("Books loaded successfully!");
        }
    }


    private Regipublisher findPublisher(String name) {
        for (Regipublisher pub : registeredPublishers) {
            if (pub.getPublisherName().equalsIgnoreCase(name)) {
                return pub;
            }
        }
        return null;
    }

    @FXML
    void Refresh(ActionEvent event) {
        ComboBox.getSelectionModel().clearSelection();
        Namefield.clear();
        Addfield.clear();
        Confield.clear();
        bookList.clear();
        textView.setText("Refreshed.");
    }

    @FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/WishListCollection.fxml");
    }

    @FXML
    public void Logout(ActionEvent actionEvent) throws IOException {
        switchTo("Login.fxml");
    }

    @FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/EntryTicket.fxml");
    }

    @FXML
    public void dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Customer.fxml");
    }
}
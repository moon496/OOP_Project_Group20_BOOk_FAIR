package com.group20.oop_project_group20_book_fair.Moon;

import com.group20.oop_project_group20_book_fair.screenSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchBookStallController {
    @javafx.fxml.FXML
    private TextField Entercatagory;
    @javafx.fxml.FXML
    private ListView<String> listview;
    @javafx.fxml.FXML
    private Label textview;

    ArrayList<Bookstall> bookstalls;

    @javafx.fxml.FXML
    public void initialize() {
        bookstalls = new ArrayList<>();
        bookstalls.add(new Bookstall("Stall A - Classic Fiction Corner", "fiction"));
        bookstalls.add(new Bookstall("Stall E - Modern Fiction Hub", "fiction"));
        bookstalls.add(new Bookstall("Stall H - Mystery & Thriller Section", "fiction"));

        bookstalls.add(new Bookstall("Stall B - Tech Books Paradise", "programming"));
        bookstalls.add(new Bookstall("Stall F - Coding Central", "programming"));
        bookstalls.add(new Bookstall("Stall J - Developer's Library", "programming"));

        bookstalls.add(new Bookstall("Stall C - Science World", "science"));
        bookstalls.add(new Bookstall("Stall G - Research Publications", "science"));
        bookstalls.add(new Bookstall("Stall K - Scientific Discoveries", "science"));

        bookstalls.add(new Bookstall("Stall D - Historical Archives", "history"));
        bookstalls.add(new Bookstall("Stall I - Ancient Civilizations", "history"));

        bookstalls.add(new Bookstall("Stall L - Love Stories Collection", "romance"));
        bookstalls.add(new Bookstall("Stall M - Romance Readers Paradise", "romance"));

        listview.getItems().clear();
        textview.setText("Enter a category and click Search.");

    }

    @javafx.fxml.FXML
    public void Search(ActionEvent actionEvent) {
        String category = Entercatagory.getText().trim();
        if (category.isEmpty()) {
            textview.setText("Please enter a category .");

            return;
        }
        ArrayList<String> matchingStalls = new ArrayList<>();

        for (Bookstall stall : bookstalls) {
            if (stall != null && stall.getCategory() != null &&
                    stall.getCategory().equalsIgnoreCase(category)) {
                matchingStalls.add(stall.getName());


            }

        }
        if (!matchingStalls.isEmpty()) {
            ObservableList<String> stallList = FXCollections.observableArrayList(matchingStalls);
            listview.setItems(stallList);
            textview.setText("Found " + matchingStalls.size() + " stall(s) for: " + category);
        } else {
            listview.setItems(FXCollections.observableArrayList());
            textview.setText("No stalls found for: " + category);

        }


    }

    @javafx.fxml.FXML
    public void BackToCD(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("Moon/Customer.fxml");

    }
}
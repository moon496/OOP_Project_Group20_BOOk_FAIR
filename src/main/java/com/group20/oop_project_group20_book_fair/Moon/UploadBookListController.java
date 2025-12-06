package com.group20.oop_project_group20_book_fair.Moon;

import com.group20.oop_project_group20_book_fair.screenSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class UploadBookListController
{
    @javafx.fxml.FXML
    private Label Textview;
    @javafx.fxml.FXML
    private TextField SelectFile;
    @javafx.fxml.FXML
    private ComboBox<String> formetBox;


    @javafx.fxml.FXML
    public void initialize() {
        formetBox.getItems().addAll("CSV", "TXT", "PDF");
        formetBox.setPromptText("Select Format");

        SelectFile.setEditable(false);
        SelectFile.setPromptText("No file selected");

        Textview.setText("Please select a file to upload");

    }

    @javafx.fxml.FXML
    public void Browse(ActionEvent actionEvent) {

         FileChooser FileChooser;
        FileChooser chooser = new FileChooser();

        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV files", "*.csv"),
                new FileChooser.ExtensionFilter("TXT files", "*.txt"),
                new FileChooser.ExtensionFilter("PDF files", "*.pdf")
        );

        File selectedFile = chooser.showOpenDialog(null);

        if (selectedFile != null) {
            SelectFile.setText(selectedFile.getAbsolutePath());

            // Auto-detect format in ComboBox
            String name = selectedFile.getName().toLowerCase();
            if (name.endsWith(".csv")) formetBox.setValue("CSV");
            else if (name.endsWith(".txt")) formetBox.setValue("TXT");
            else if (name.endsWith(".pdf")) formetBox.setValue("PDF");

            Textview.setText("");
        }
    }

    @javafx.fxml.FXML
    public void UploadBook(ActionEvent actionEvent) {
        String path = SelectFile.getText();
        String selectedFormat = formetBox.getValue();

        if (path.isEmpty()) {
            Textview.setText("Please select a file first!");

            return;
        }
        if (selectedFormat == null) {
            Textview.setText("Please choose a file format!");

            return;
        }
        File file = new File(path);

        if (!file.exists()) {
            Textview.setText("Selected file does not exist!");

            return;
        }
        if (!file.getName().toLowerCase().endsWith(selectedFormat.toLowerCase())) {
            Textview.setText("File format does not match selected format!");

            return;
        }
        File folder = new File("uploaded_books");
        if (!folder.exists()) folder.mkdirs();
        File destination = new File(folder, file.getName());

        try {
            Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

            Textview.setText("Books uploaded successfully!");
            Textview.setStyle("-fx-text-fill: green;");

        } catch (IOException e) {
            Textview.setText("Failed to upload!");
            Textview.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }



    }

    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/ManageStallBooking.fxml");
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
    public void Clear(ActionEvent actionEvent) {
        SelectFile.clear();
        formetBox.setValue(null);
        formetBox.setPromptText("Select Format");
        Textview.setText("Please select a file to upload");
        Textview.setStyle("");

    }
}
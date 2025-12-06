package com.group20.oop_project_group20_book_fair.Moon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class RegisterPublisherProfileController
{
    @javafx.fxml.FXML
    private TextField Numberfield;
    @javafx.fxml.FXML
    private PasswordField conPass;
    @javafx.fxml.FXML
    private TextField Namefiled;
    @javafx.fxml.FXML
    private TextField Emailfield;
    @javafx.fxml.FXML
    private PasswordField passwordfield;
    @javafx.fxml.FXML
    private Label textfield;
    @javafx.fxml.FXML
    private TextField Addressfield;

    @javafx.fxml.FXML
    private TableColumn <Regipublisher , String> numberCol;
    @javafx.fxml.FXML
    private TableView <Regipublisher>tableview;
    @javafx.fxml.FXML
    private TableColumn <Regipublisher , String>AddressCol;

    @javafx.fxml.FXML
    private TableColumn <Regipublisher , String>NameCol;

    private final String FILE_NAME = "publisherData.txt";
    private final ObservableList<Regipublisher> publisherList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        textfield.setText("");
        NameCol.setCellValueFactory(data -> data.getValue().publisherNameProperty());
        AddressCol.setCellValueFactory(data -> data.getValue().addressProperty());
        numberCol.setCellValueFactory(data -> data.getValue().contactProperty());
        loadPublisherData();
        tableview.setItems(publisherList);


    }

    @javafx.fxml.FXML
    public void Registration(ActionEvent actionEvent) {
        String name = Namefiled.getText().trim();
        String email = Emailfield.getText().trim();
        String address = Addressfield.getText().trim();
        String contact = Numberfield.getText().trim();
        String pass = passwordfield.getText().trim();
        String confirm = conPass.getText().trim();
        if (name.isEmpty()) {
            textfield.setText("Publisher name required!");
            return;
        }
        if (email.isEmpty()) {
            textfield.setText("Email required!");
            return;
        }
        if (address.isEmpty()) {
            textfield.setText("Address required!");
            return;
        }
        if (!pass.equals(confirm)) {
            textfield.setText("Password does not match!");
            return;

        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(name + "," + email + "," + address + "," + contact + "," + pass);
            writer.newLine();


        } catch (IOException e) {
            textfield.setText("Error saving publisher!");
            return;
        }
        publisherList.add(new Regipublisher(name, address, contact));

        textfield.setText("Registration Successful! Publisher Saved.");

    }

    @javafx.fxml.FXML
    public void Clean(ActionEvent actionEvent) {
        Namefiled.clear();
        Emailfield.clear();
        Addressfield.clear();
        Numberfield.clear();
        passwordfield.clear();
        conPass.clear();
        textfield.setText("");
    }

    @javafx.fxml.FXML
    public void showInTable(ActionEvent actionEvent) {
        publisherList.clear();
        loadPublisherData();
        tableview.refresh();
        textfield.setText("Data loaded into table. Total: " + publisherList.size());
    }

    private void loadPublisherData() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            textfield.setText("No data file found!");
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

                    publisherList.add(new Regipublisher(name, address, contact));
                }
            }
        } catch (IOException e) {
            textfield.setText("Error loading data: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void Delete(ActionEvent actionEvent) {
        Regipublisher selected = tableview.getSelectionModel().getSelectedItem();

        if (selected == null) {
            textfield.setText("❗ Please select a row to delete!");
            return;
        }
        publisherList.remove(selected);

        saveAllPublishersToFile();

        textfield.setText("✅ Publisher deleted successfully!");
    }
    private void saveAllPublishersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Regipublisher pub : publisherList) {
                writer.write(pub.getPublisherName() + ",dummy@email.com," +
                        pub.getAddress() + "," + pub.getContact() + ",dummy123");
                writer.newLine();
            }
        } catch (IOException e) {
            textfield.setText("Error saving data!");
        }

    }
    @javafx.fxml.FXML
    public void Next(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/UploadBookList.fxml");
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        switchTo("Moon/Publisher.fxml");
    }
}

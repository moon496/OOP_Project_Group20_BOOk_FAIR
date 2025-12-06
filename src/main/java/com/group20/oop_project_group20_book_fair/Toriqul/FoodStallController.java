package coop_project_group20_book_fair.Toriqul;

import com.bookfair.app.models.*;
import com.bookfair.app.util.SceneUtil;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.UUID;

public class FoodStallController {

    @FXML private Button btnLogout;

    @FXML private TextField txtOwnerName;
    @FXML private TextField txtStallName;
    @FXML private TextField txtContact;
    @FXML private TableView<StallRegistration> tblRegistrations;
    @FXML private TableColumn<StallRegistration, String> colOwner;
    @FXML private TableColumn<StallRegistration, String> colStall;
    @FXML private TableColumn<StallRegistration, String> colContact;
    @FXML private TableColumn<StallRegistration, String> colStatus;

    private final ObservableList<StallRegistration> registrations =
            FXCollections.observableArrayList();

    @FXML private TextArea txtMessage;
    @FXML private ListView<String> listMessages;

    @FXML private TextField txtMenuItem;
    @FXML private ListView<String> listMenus;

    @FXML private TextField txtPayStall;
    @FXML private TextField txtPayAmount;
    @FXML private TextField txtPayDate;
    @FXML private TableView<PaymentRecord> tblPayments;
    @FXML private TableColumn<PaymentRecord, String> colPayStall;
    @FXML private TableColumn<PaymentRecord, Double> colPayAmount;
    @FXML private TableColumn<PaymentRecord, String> colPayDate;
    private final ObservableList<PaymentRecord> payments =
            FXCollections.observableArrayList();

    @FXML private TextField txtLayoutStall;
    @FXML private TextField txtLayoutLocation;
    @FXML private ListView<String> listLayout;


    @FXML private TextField txtFeedbackFromStall;
    @FXML private ListView<String> listStallFeedback;

    @FXML
    public void initialize() {
        colOwner.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getOwnerName()));
        colStall.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStallName()));
        colContact.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getContact()));
        colStatus.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStatus()));
        tblRegistrations.setItems(registrations);

        colPayStall.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStallName()));
        colPayAmount.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getAmount()).asObject());
        colPayDate.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDate()));
        tblPayments.setItems(payments);
    }

    @FXML
    private void onRegisterStall() {
        String owner = txtOwnerName.getText();
        String stall = txtStallName.getText();
        String contact = txtContact.getText();

        if (owner.isBlank() || stall.isBlank() || contact.isBlank()) {
            showAlert("Owner, stall name and contact are required.");
            return;
        }

        StallRegistration reg = new StallRegistration(
                UUID.randomUUID().toString(),
                owner, stall, contact, "PENDING"
        );
        registrations.add(reg);

        txtOwnerName.clear();
        txtStallName.clear();
        txtContact.clear();
    }

    @FXML
    private void onApprove() {
        StallRegistration selected = tblRegistrations.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Select a registration to approve.");
            return;
        }
        selected.setStatus("APPROVED");
        tblRegistrations.refresh();
    }

    @FXML
    private void onReject() {
        StallRegistration selected = tblRegistrations.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Select a registration to reject.");
            return;
        }
        selected.setStatus("REJECTED");
        tblRegistrations.refresh();
    }

    @FXML
    private void onUpdateContact() {
        StallRegistration selected = tblRegistrations.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Select a stall to update.");
            return;
        }
        String newContact = txtContact.getText();
        if (newContact.isBlank()) {
            showAlert("Enter new contact in the contact field.");
            return;
        }
        selected.setContact(newContact);
        tblRegistrations.refresh();
        txtContact.clear();
    }

    @FXML
    private void onSendMessage() {
        String msg = txtMessage.getText();
        if (msg.isBlank()) {
            showAlert("Message cannot be empty.");
            return;
        }
        listMessages.getItems().add("Manager: " + msg);
        txtMessage.clear();
    }

    @FXML
    private void onAddMenuItem() {
        String item = txtMenuItem.getText();
        if (item.isBlank()) {
            showAlert("Menu item is required.");
            return;
        }
        listMenus.getItems().add("PENDING: " + item);
        txtMenuItem.clear();
    }

    @FXML
    private void onApproveMenu() {
        int idx = listMenus.getSelectionModel().getSelectedIndex();
        if (idx < 0) {
            showAlert("Select a menu item to approve.");
            return;
        }
        String current = listMenus.getItems().get(idx);
        listMenus.getItems().set(idx, current.replace("PENDING:", "APPROVED:"));
    }

    @FXML
    private void onRequestChange() {
        int idx = listMenus.getSelectionModel().getSelectedIndex();
        if (idx < 0) {
            showAlert("Select a menu item to request changes.");
            return;
        }
        String current = listMenus.getItems().get(idx);
        listMenus.getItems().set(idx, current.replace("PENDING:", "CHANGE_REQ:"));
    }

    @FXML
    private void onAddPayment() {
        String stall = txtPayStall.getText();
        String amountText = txtPayAmount.getText();
        String date = txtPayDate.getText();

        if (stall.isBlank() || amountText.isBlank() || date.isBlank()) {
            showAlert("Stall, amount and date are required.");
            return;
        }
        try {
            double amount = Double.parseDouble(amountText);
            payments.add(new PaymentRecord(stall, amount, date));
            txtPayStall.clear();
            txtPayAmount.clear();
            txtPayDate.clear();
        } catch (NumberFormatException e) {
            showAlert("Amount must be numeric.");
        }
    }

    @FXML
    private void onAssignLayout() {
        String stall = txtLayoutStall.getText();
        String loc = txtLayoutLocation.getText();
        if (stall.isBlank() || loc.isBlank()) {
            showAlert("Stall and location are required.");
            return;
        }
        listLayout.getItems().add(stall + " -> " + loc);
        txtLayoutStall.clear();
        txtLayoutLocation.clear();
    }

    @FXML
    private void onAddStallFeedback() {
        String fb = txtFeedbackFromStall.getText();
        if (fb.isBlank()) {
            showAlert("Feedback cannot be empty.");
            return;
        }
        listStallFeedback.getItems().add(fb);
        txtFeedbackFromStall.clear();
    }

    @FXML
    private void onLogout() {
        SceneUtil.switchTo(btnLogout, "/fxml/login.fxml", "Book Fair - Login");
    }

    private void showAlert(String msg) {
        new Alert(Alert.AlertType.WARNING, msg).showAndWait();
    }
}

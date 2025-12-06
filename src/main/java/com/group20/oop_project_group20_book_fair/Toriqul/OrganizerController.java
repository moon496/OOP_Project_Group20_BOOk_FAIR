package com.group20.oop_project_group20_book_fair.Toriqul;

import com.bookfair.app.models.*;
import com.bookfair.app.util.SceneUtil;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.UUID;

public class OrganizerController {

    @FXML private Button btnLogout;

    @FXML private TextField txtVenueName;
    @FXML private TextField txtVenueEventType;
    @FXML private TextField txtVenueLocation;
    @FXML private TextField txtVenueCapacity;
    @FXML private TableView<VenueRecord> tblVenues;
    @FXML private TableColumn<VenueRecord, String> colVenueName;
    @FXML private TableColumn<VenueRecord, String> colVenueType;
    @FXML private TableColumn<VenueRecord, String> colVenueLocation;
    @FXML private TableColumn<VenueRecord, Integer> colVenueCapacity;
    private final ObservableList<VenueRecord> venues = FXCollections.observableArrayList();

    @FXML private TextField txtStallNo;
    @FXML private TextField txtStallName;
    @FXML private TextField txtStallOwner;
    @FXML private TableView<StallInfo> tblStalls;
    @FXML private TableColumn<StallInfo, String> colStallNo;
    @FXML private TableColumn<StallInfo, String> colStallName;
    @FXML private TableColumn<StallInfo, String> colStallOwner;
    private final ObservableList<StallInfo> stalls = FXCollections.observableArrayList();

    @FXML private Slider sldPublicity;
    @FXML private Label lblPublicityValue;

    @FXML private TextField txtServiceName;
    @FXML private TextField txtServiceCount;
    @FXML private TableView<ServiceRecord> tblServices;
    @FXML private TableColumn<ServiceRecord, String> colServiceName;
    @FXML private TableColumn<ServiceRecord, Integer> colServiceCount;
    private final ObservableList<ServiceRecord> services = FXCollections.observableArrayList();

    @FXML private TextField txtInvestmentPercent;
    @FXML private Label lblInvestmentSummary;

    @FXML private TextArea txtFeedbackInput;
    @FXML private ListView<String> listFeedback;

    @FXML private TextField txtFacilityName;
    @FXML private ListView<String> listFacilities;

    @FXML private TextArea txtImprovementIdea;
    @FXML private ListView<String> listImprovements;

    @FXML
    public void initialize() {
        colVenueName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        colVenueType.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEventType()));
        colVenueLocation.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getLocation()));
        colVenueCapacity.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCapacity()).asObject());
        tblVenues.setItems(venues);

        colStallNo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStallNo()));
        colStallName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getStallName()));
        colStallOwner.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getOwnerName()));
        tblStalls.setItems(stalls);

        colServiceName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getServiceName()));
        colServiceCount.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCustomerCount()).asObject());
        tblServices.setItems(services);

        sldPublicity.valueProperty().addListener((obs, oldV, newV) ->
                lblPublicityValue.setText(String.format("%.0f%%", newV.doubleValue()))
        );
    }

    @FXML
    private void onSaveVenue() {
        String name = txtVenueName.getText();
        String type = txtVenueEventType.getText();
        String loc = txtVenueLocation.getText();
        String capText = txtVenueCapacity.getText();

        if (name.isBlank() || type.isBlank() || loc.isBlank() || capText.isBlank()) {
            showAlert("All venue fields are required.");
            return;
        }
        int capacity;
        try {
            capacity = Integer.parseInt(capText);
        } catch (NumberFormatException e) {
            showAlert("Capacity must be a number.");
            return;
        }

        VenueRecord record = new VenueRecord(
                UUID.randomUUID().toString(), name, type, loc, capacity
        );
        venues.add(record);

        txtVenueName.clear();
        txtVenueEventType.clear();
        txtVenueLocation.clear();
        txtVenueCapacity.clear();
    }

    @FXML
    private void onAddStall() {
        String no = txtStallNo.getText();
        String name = txtStallName.getText();
        String owner = txtStallOwner.getText();

        if (no.isBlank() || name.isBlank() || owner.isBlank()) {
            showAlert("Stall no, name and owner are required.");
            return;
        }

        stalls.add(new StallInfo(no, name, owner));
        txtStallNo.clear();
        txtStallName.clear();
        txtStallOwner.clear();
    }

    @FXML
    private void onShowPublicity() {
        double value = sldPublicity.getValue();
        showInfo("Current publicity level: " + (int) value + "%");
    }

    @FXML
    private void onAddService() {
        String name = txtServiceName.getText();
        String countText = txtServiceCount.getText();
        if (name.isBlank() || countText.isBlank()) {
            showAlert("Service name and customer count are required.");
            return;
        }
        int count;
        try {
            count = Integer.parseInt(countText);
        } catch (NumberFormatException e) {
            showAlert("Customer count must be a number.");
            return;
        }
        services.add(new ServiceRecord(name, count));
        txtServiceName.clear();
        txtServiceCount.clear();
    }

    @FXML
    private void onSaveInvestment() {
        String text = txtInvestmentPercent.getText();
        if (text.isBlank()) {
            showAlert("Investment percentage is required.");
            return;
        }
        try {
            double percent = Double.parseDouble(text);
            lblInvestmentSummary.setText("Total investment: " + percent + "% of budget");
        } catch (NumberFormatException e) {
            showAlert("Investment must be a number.");
        }
    }

    @FXML
    private void onAddFeedback() {
        String fb = txtFeedbackInput.getText();
        if (fb.isBlank()) {
            showAlert("Feedback cannot be empty.");
            return;
        }
        listFeedback.getItems().add(fb);
        txtFeedbackInput.clear();
    }

    @FXML
    private void onAddFacility() {
        String f = txtFacilityName.getText();
        if (f.isBlank()) {
            showAlert("Facility name is required.");
            return;
        }
        listFacilities.getItems().add(f);
        txtFacilityName.clear();
    }

    @FXML
    private void onAddImprovement() {
        String idea = txtImprovementIdea.getText();
        if (idea.isBlank()) {
            showAlert("Idea cannot be empty.");
            return;
        }
        listImprovements.getItems().add(idea);
        txtImprovementIdea.clear();
    }

    @FXML
    private void onLogout() {
        SceneUtil.switchTo(btnLogout, "/fxml/login.fxml", "Book Fair - Login");
    }

    private void showAlert(String msg) {
        new Alert(Alert.AlertType.WARNING, msg).showAndWait();
    }

    private void showInfo(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).showAndWait();
    }
}

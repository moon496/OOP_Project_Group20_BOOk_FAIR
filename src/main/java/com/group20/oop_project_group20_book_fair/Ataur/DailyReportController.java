package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class DailyReportController
{
    @javafx.fxml.FXML
    private TextField totalalerthandle;
    @javafx.fxml.FXML
    private BarChart chartdr;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void backtodashboarddr(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/SecurityOfficerDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void previous(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/Parking.fxml");
    }

    @javafx.fxml.FXML
    public void savedata(ActionEvent actionEvent) {

    }
}
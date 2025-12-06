package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.group20.oop_project_group20_book_fair.screenSwitcher.switchTo;

public class AccessControlController {
    @javafx.fxml.FXML
    private TextField entrytype;
    @javafx.fxml.FXML
    private TextArea showsaveddata;
    @javafx.fxml.FXML
    private TextField personid;
    @javafx.fxml.FXML
    private TextField personname;

    @javafx.fxml.FXML
    public void backtodashboardstafflog(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void nextstafflog(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/Parking.fxml");
    }

    @javafx.fxml.FXML
    public void backstafflog(ActionEvent actionEvent) throws IOException {
        switchTo("Ataur/Emergency.fxml");
    }

    @javafx.fxml.FXML
    public void savestafflog(ActionEvent actionEvent) {
    }
}

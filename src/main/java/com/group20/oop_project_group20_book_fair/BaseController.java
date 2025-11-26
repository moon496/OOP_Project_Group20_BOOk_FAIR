package com.group20.oop_project_group20_book_fair;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseController {
    @javafx.fxml.FXML
    public void logOut(ActionEvent actionEvent) throws IOException {
            screenSwitcher.switchTo("Login.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void goToDashboard(ActionEvent actionEvent) throws IOException {
        screenSwitcher.switchTo("UserDashboard.fxml", actionEvent);
    }

    public static void switchTo(String fxml, ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource(fxml)
        );
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

}

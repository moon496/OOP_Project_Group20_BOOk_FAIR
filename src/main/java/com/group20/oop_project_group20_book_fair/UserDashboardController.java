package com.group20.oop_project_group20_book_fair;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void Logout(ActionEvent actionEvent)throws IOException {
        AnchorPane root = FXMLLoader.load(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(root);
        screenSwitcher.stage.setScene(scene);
    }


}
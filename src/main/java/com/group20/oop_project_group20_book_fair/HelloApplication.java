package com.group20.oop_project_group20_book_fair;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        screenSwitcher.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bookfair");
        stage.setScene(scene);
        stage.show();
    }


}

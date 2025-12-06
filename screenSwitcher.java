package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class screenSwitcher {
    public static Stage stage;

    public static void switchScreen(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    screenSwitcher.class.getResource("/com/group20/oop_project_group20_book_fair/" + fxmlPath)
            );
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.group20.oop_project_group20_book_fair.Toriqul;

import com.bookfair.app.util.SceneUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private Button btnOrganizer;

    @FXML
    private Button btnFoodStall;

    @FXML
    private void onOrganizer() {
        SceneUtil.switchTo(btnOrganizer,
                "/fxml/organizer.fxml",
                "Book Fair - Organizer (User 5)");
    }

    @FXML
    private void onFoodStall() {
        SceneUtil.switchTo(btnFoodStall,
                "/fxml/foodstall.fxml",
                "Book Fair - Food Stall Manager (User 6)");
    }
}

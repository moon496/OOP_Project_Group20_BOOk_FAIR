module com.group20.oop_project_group20_book_fair {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group20.oop_project_group20_book_fair to javafx.fxml;
    exports com.group20.oop_project_group20_book_fair;
}
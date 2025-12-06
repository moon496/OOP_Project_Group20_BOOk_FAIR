module com.group20.oop_project_group20_book_fair {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    requires jdk.jfr;



    //requires com.group20.oop_project_group20_book_fair;
    //requires com.group20.oop_project_group20_book_fair;
    //requires com.group20.oop_project_group20_book_fair;


    opens com.group20.oop_project_group20_book_fair to javafx.fxml;
    exports com.group20.oop_project_group20_book_fair;

    opens com.group20.oop_project_group20_book_fair.Moon to javafx.fxml;
    exports com.group20.oop_project_group20_book_fair.Moon;
}
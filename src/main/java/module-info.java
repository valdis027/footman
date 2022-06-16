module com.example.footman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.footman to javafx.fxml;
    exports com.example.footman;
}
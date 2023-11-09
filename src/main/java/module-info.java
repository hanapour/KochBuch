module com.example.teszo {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens com.example.kochBuch to javafx.fxml;
    exports com.example.kochBuch;
}
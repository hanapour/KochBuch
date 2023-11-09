module com.example.teszo {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens com.example.kochBuch to javafx.fxml;
    opens com.example.kochBuch.Menu to javafx.fxml;
    opens com.example.kochBuch.GerichteController to javafx.fxml;
    exports com.example.kochBuch;
    exports com.example.kochBuch.GerichteController to javafx.fxml;
    exports com.example.kochBuch.Menu;
}
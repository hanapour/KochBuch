module com.example.teszo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.kochBuch to javafx.fxml;
    exports com.example.kochBuch;
}
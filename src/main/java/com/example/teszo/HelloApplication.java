package com.example.teszo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("KochBuch App");

        // Create the main layout using BorderPane
        BorderPane mainLayout = new BorderPane();


        // Add Logo (center)
        // Add Favorite and Category Icons (right)
        // You can use HBox or VBox for these sections

        // Create the scene and set it in the stage
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

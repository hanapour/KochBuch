package com.example.teszo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("KochBuch App");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartView.fxml"));
        // Create the main layout using BorderPane
       // BorderPane mainLayout = new BorderPane();


        // Add Logo (center)
        // Add Favorite and Category Icons (right)
        // You can use HBox or VBox for these sections

        // Create the scene and set it in the stage
        Scene scene = new Scene(fxmlLoader.load());
        // Bitte nicht ändern , es soll so bleiben setResizable(false)
        primaryStage.setResizable(false);
        primaryStage.setFullScreenExitHint("Hello , Um exit drucke bitte die 'esc' taste");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("esc"));
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}


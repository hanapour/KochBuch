package com.example.kochBuch;

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
    protected static Stage mainstage;
    public MainApplication(){};
    @Override
    public void start(Stage primaryStage) throws IOException {
        mainstage = primaryStage;
        mainstage.setTitle("KochBuch App");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartView.fxml"));

        Scene scene = new Scene(fxmlLoader.load(),800,600);
        // Bitte nicht ändern, es soll so bleiben setResizable(false)
        mainstage.setResizable(false);
        //mainstage.setFullScreenExitHint("Hello , Um exit drucke bitte die 'esc' taste");
        //mainstage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("esc"));
        mainstage.setScene(scene);

        mainstage.show();
    }
}


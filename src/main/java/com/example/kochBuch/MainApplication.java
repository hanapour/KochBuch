package com.example.kochBuch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    protected static Stage mainstage;
    protected static Scene maimscene;
    public MainApplication(){};
    @Override
    public void start(Stage primaryStage) throws IOException {
        mainstage = primaryStage;
        mainstage.setTitle("KochBuch App");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartView.fxml"));
        maimscene = new Scene(fxmlLoader.load(),800,630);
        mainstage.setResizable(false);
        mainstage.setScene(maimscene);
        mainstage.show();
    }

}


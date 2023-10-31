package com.example.kochBuch;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VeganController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    private void loadFXML(String fxmlFileName) throws Exception {
        Stage stage = MainApplication.mainstage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFileName));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void vegan(MouseEvent event)  throws Exception{
        loadFXML("VeganView.fxml");
    }
    @FXML void fleisch(MouseEvent event)  throws Exception{
        loadFXML("FleischView.fxml");
    }
    @FXML void seafood(MouseEvent event)  throws Exception{
        loadFXML("SeafoodView.fxml");
    }
    @FXML void vorspeise(MouseEvent event)  throws Exception{
        loadFXML("VorspeiseView.fxml");
    }
    @FXML void nachspeise(MouseEvent event)  throws Exception{
        loadFXML("NachspeiseView.fxml");
    }
    @FXML void persisch(MouseEvent event)  throws Exception{
        loadFXML("PersischView.fxml");
    }
    @FXML void OnClickBack(MouseEvent event)  throws Exception{
        loadFXML("categoryView.fxml");
    }
}

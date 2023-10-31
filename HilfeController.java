package com.example.kochBuch;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HilfeController extends Application {

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

    @FXML void login(MouseEvent event)  throws Exception{
        loadFXML("StartView.fxml");
    }
    @FXML void kategorie(MouseEvent event)  throws Exception{
        loadFXML("KategorieView.fxml");
    }
    @FXML void favoriten(MouseEvent event)  throws Exception{
        loadFXML("FavoritenView.fxml");
    }
    @FXML void impressum(MouseEvent event)  throws Exception{
        loadFXML("ImpressumView.fxml");
    }
    @FXML void hilfe(MouseEvent event)  throws Exception{
        loadFXML("HilfeView.fxml");
    }
}

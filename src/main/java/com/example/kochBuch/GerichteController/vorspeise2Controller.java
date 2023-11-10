package com.example.kochBuch.GerichteController;

import com.example.kochBuch.MainApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class vorspeise2Controller extends Application {

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
        loadFXML("/com/example/kochBuch/KategorienView/VeganView.fxml");
    }
    @FXML void fleisch(MouseEvent event)  throws Exception{
        loadFXML("/com/example/kochBuch/KategorienView/FleischView.fxml");
    }
    @FXML void seafood(MouseEvent event)  throws Exception{
        loadFXML("/com/example/kochBuch/KategorienView/SeafoodView.fxml");
    }
    @FXML void vorspeise(MouseEvent event)  throws Exception{
        loadFXML("/com/example/kochBuch/KategorienView/VorspeiseView.fxml");
    }
    @FXML void nachspeise(MouseEvent event)  throws Exception{
        loadFXML("/com/example/kochBuch/KategorienView/NachspeiseView.fxml");
    }
    @FXML void persisch(MouseEvent event)  throws Exception{
        loadFXML("/com/example/kochBuch/KategorienView/PersischView.fxml");
    }
    @FXML void OnClickBack(MouseEvent event)  throws Exception{
        loadFXML("/com/example/kochBuch/KategorienView/VorspeiseView.fxml");
    }
    @FXML void OnHomeClick(MouseEvent event)  throws Exception{
        loadFXML("/com/example/kochBuch/StartView.fxml");
    }
}

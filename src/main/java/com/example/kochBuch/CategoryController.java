package com.example.kochBuch;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.event.Event;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    private ImageView btnBack;
    @FXML
    private Stage primaryStage;
    @FXML
    void OnBackClick(MouseEvent event ) throws Exception {
        loadStartPage(event);
    }

    // Methode zum Laden der Startseite
     void loadStartPage(MouseEvent event) throws Exception {
         UserFxmlLoader.loadFXML("startView.fxml");
    }
    @FXML void vegan(MouseEvent event)  throws Exception{
        UserFxmlLoader.loadFXML("VeganView.fxml");
    }
    @FXML void fleisch(MouseEvent event)  throws Exception{
        UserFxmlLoader.loadFXML("FleischView.fxml");
    }
    @FXML void seafood(MouseEvent event)  throws Exception{
        UserFxmlLoader.loadFXML("SeafoodView.fxml");
    }
    @FXML void vorspeise(MouseEvent event)  throws Exception{
        UserFxmlLoader.loadFXML("VorspeiseView.fxml");
    }
    @FXML void nachspeise(MouseEvent event)  throws Exception{
        UserFxmlLoader.loadFXML("NachspeiseView.fxml");
    }
    @FXML void persisch(MouseEvent event)  throws Exception{
        UserFxmlLoader.loadFXML("PersischView.fxml");
    }
    /*@FXML void OnClickBack(MouseEvent event)  throws Exception{
        loadFXML("StartView.fxml");
    }*/

}

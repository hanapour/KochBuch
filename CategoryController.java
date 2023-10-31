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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("startView.fxml"));
        Parent startPage = (Parent) fxmlLoader.load();
        Scene scene = new Scene(startPage);

         if (primaryStage != null) {
             primaryStage.setScene(scene);
         } else {
             // Schließe die aktuelle Stage
             Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             currentStage.close();
             // Erstelle eine neue Stage, wenn keine vorhanden ist
             Stage stage = new Stage();
             stage.setScene(scene);
             stage.show();
         }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void loadFXML(String fxmlFileName) throws Exception {
        Stage stage = MainApplication.mainstage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFileName));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML void vegan(MouseEvent event)  throws Exception{
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
    /*@FXML void OnClickBack(MouseEvent event)  throws Exception{
        loadFXML("StartView.fxml");
    }*/

}

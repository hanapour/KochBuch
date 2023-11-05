package com.example.kochBuch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

        @FXML
        private Button Impressum;

        @FXML
        private Button btnAnmelden;

        @FXML
        private Button btnHilfe;

        @FXML
        private Button btnKategorie;

        @FXML
        private Button btnRegistrieren;

        @FXML
        void OnHelpClick(MouseEvent event) throws Exception {
            UserFxmlLoader.loadFXML("HilfeView.fxml");
        }

        @FXML
        void OnImpressumClick(MouseEvent event) throws Exception {
            UserFxmlLoader.loadFXML("ImpressumView.fxml");

        }

        @FXML
        void OnKategorieClick(MouseEvent event)throws Exception  {
            UserFxmlLoader.loadFXML("categoryView.fxml");
        }

        @FXML
        void OnSingUpClick(MouseEvent event) throws Exception {
            UserFxmlLoader.loadFXML("registerView.fxml");

        }
        @FXML
        void  OnSingInClick(MouseEvent event )throws  Exception{
            UserFxmlLoader.loadFXML("AnmeldenView.fxml");
        }





}

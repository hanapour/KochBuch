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
            loadFXML("HilfeView.fxml");
        }

        @FXML
        void OnImpressumClick(MouseEvent event) throws Exception {
            loadFXML("ImpressumView.fxml");

        }

        @FXML
        void OnKategorieClick(MouseEvent event)throws Exception  {
            loadFXML("categoryView.fxml");
        }

        @FXML
        void OnSingUpClick(MouseEvent event) throws Exception {
            loadFXML("registerView.fxml");

        }
        @FXML
        void  OnSingInClick(MouseEvent event )throws  Exception{
            loadFXML("AnmeldenView.fxml");
        }
        @FXML


    private void loadFXML(String fxmlFileName) throws Exception {
        Stage stage = MainApplication.mainstage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFileName));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

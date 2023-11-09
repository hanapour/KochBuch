package com.example.kochBuch.Menu;
import com.example.kochBuch.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private void loadFXML(String fxmlFileName) throws Exception {
        Stage stage = MainApplication.mainstage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFileName));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public Button CloseButton;

    @FXML
    public TextField ConfirmTextField;

    @FXML
    public TextField FirstnameTextField;

    @FXML
    public TextField LastnameTextField;

    @FXML
    public AnchorPane Pane2;

    @FXML
    public TextField PasswordTextField;

    @FXML
    public Button RegisterButton;

    @FXML
    public TextField UsernameTextField;

    @FXML
    public ImageView schieldimageView;
    @FXML
    public Stage primaryStage;

    @FXML void OnCloseClick(MouseEvent event)  throws Exception{
        System.out.println("Das Fenster wurde geschlossen!");
        loadFXML("/com/example/kochBuch/StartView.fxml");
    }
    @FXML void OnRegisterClick(MouseEvent event)  throws Exception{
        System.out.println("Sie wurden registriert!");
        loadFXML("/com/example/kochBuch/StartView.fxml");
    }
    @FXML void OnAnmeldenClick(MouseEvent event)  throws Exception{
        System.out.println("Sie wurden angemeldet!");
        loadFXML("/com/example/kochBuch/StartView.fxml");
    }

}

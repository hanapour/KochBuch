package com.example.kochBuch.MenuControllerOrdner;
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
    private Button CloseButton;

    @FXML
    private TextField ConfirmTextField;

    @FXML
    private TextField FirstnameTextField;

    @FXML
    private TextField LastnameTextField;

    @FXML
    private AnchorPane Pane2;

    @FXML
    private TextField PasswordTextField;

    @FXML
    private Button RegisterButton;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private ImageView schieldimageView;
    @FXML
    private Stage primaryStage;
    /*@FXML
    void OnCloseRegisterClick(MouseEvent event) throws Exception {
    CategoryController categoryController= new CategoryController();
    categoryController.loadStartPage(event);

    }*/
    @FXML void OnCloseRegisterClick(MouseEvent event)  throws Exception{
        loadFXML("/com/example/kochBuch/MenuViewOrdner/MenuView.fxml");
    }

}

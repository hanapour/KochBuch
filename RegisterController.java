package com.example.kochBuch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    @FXML
    void OnCloseRegisterClick(MouseEvent event) throws Exception {
    CategoryController categoryController= new CategoryController();
    categoryController.loadStartPage(event);

    }

}

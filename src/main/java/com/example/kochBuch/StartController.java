package com.example.kochBuch;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


        @FXML
        private ImageView btnCategory;

        @FXML
        private ImageView btnMenu;

        @FXML
        private ImageView btnVaforite;


    @FXML
    void ONClickSingup(MouseEvent event) throws Exception {
        loadFXML("register.fxml");
    }

    @FXML
    void OnCategoryClick(MouseEvent event) throws Exception {
        loadFXML("categoryView.fxml");
    }

    private void loadFXML(String fxmlFileName) throws Exception {
        Stage stage = MainApplication.mainstage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFileName));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    }
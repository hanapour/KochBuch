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

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {
    @FXML
    private ImageView btnBack;
    @FXML
    private Stage primaryStage;
    @FXML
    void OnBackClick(MouseEvent event) throws Exception {
        loadStartPage();
    }

    // Methode zum Laden der Startseite
    private void loadStartPage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("startView.fxml"));
        Parent startPage = (Parent) fxmlLoader.load();
        Scene scene = new Scene(startPage);
        // Verwende die vorhandene Stage (primaryStage) oder erstelle eine neue
        Stage stage = primaryStage != null ? primaryStage : new Stage();
        stage.setScene(scene);
        stage.show();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}

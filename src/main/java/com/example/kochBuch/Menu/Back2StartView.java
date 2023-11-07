package com.example.kochBuch;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Back2StartView implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void OnBackClick(MouseEvent event) throws Exception {
        UserFxmlLoader.loadFXML("StartView.fxml");
    }


}

package com.example.kochBuch.Menu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class FavoriteController implements Initializable {

    @FXML
    private ImageView btnBackFavorite;

    @FXML
    void OnBackClick(MouseEvent event ) throws Exception {
        CategoryController categoryController = new CategoryController();
        categoryController.loadStartPage(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

package com.example.kochBuch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
public class FavoriteController implements FavoritenButtonListener {
    @FXML
    private ScrollPane imageScrollPane;

    @FXML
    private HBox HboxScrollPane;
    private final List<String> favoritenBilder = new ArrayList<>();
    private int aktuelleFavoritenIndex = 0;

    public void OnBackClick(MouseEvent event) throws Exception {
        UserFxmlLoader.loadFXML("StartView.fxml");
    }
    public void addFavorit(String bildpfad) {
        // Das soll aus dem DatenBank:<< Gene alle können local testen und weiter entwickeln >>
        favoritenBilder.add(bildpfad);
        ImageView imageView = new ImageView(new Image(bildpfad));
        imageView.setFitWidth(200); // Passen Sie die Größe an
        imageView.setPreserveRatio(true);
        ((HBox) imageScrollPane.getContent()).getChildren().add(imageView);
    }
    public void deleteFavorit(int index) {
        // Hier soll so: wenn noch einmal auf den Favoriten btn gedrückt soll
        // Delete Statement where Favoriten id gleich rezept id....
        if (index >= 0 && index < favoritenBilder.size()) {
            favoritenBilder.remove(index);
            ((HBox) imageScrollPane.getContent()).getChildren().remove(index);
        }
    }
    // Methode zum Anzeigen des nächsten Favoriten
    @FXML
    void showNextFavorit(MouseEvent event)  {
        if (!favoritenBilder.isEmpty()) {
            aktuelleFavoritenIndex = (aktuelleFavoritenIndex + 1) % favoritenBilder.size();
            updateImageView();
        }
    }
    // Methode zum Anzeigen des vorherigen Favoriten
    @FXML
    void showPreviousFavorit(MouseEvent event) {
        if (!favoritenBilder.isEmpty()) {
            aktuelleFavoritenIndex = (aktuelleFavoritenIndex - 1 + favoritenBilder.size()) % favoritenBilder.size();
            updateImageView();
        }
    }

    // Methode zum Aktualisieren des aktuellen Favoritenbildes
    private void updateImageView() {
        if (!favoritenBilder.isEmpty()) {
            String aktuellesBildpfad = favoritenBilder.get(aktuelleFavoritenIndex);
            ImageView imageView = new ImageView(new Image(aktuellesBildpfad));
            imageView.setFitWidth(200); // Passen Sie die Größe an
            imageView.setPreserveRatio(true);
            ((HBox) imageScrollPane.getContent()).getChildren().setAll(imageView);
        }
    }
    @FXML
    public void onFavoritenButtonClicked(MouseEvent event) throws MalformedURLException {
        System.out.println("ICH BIN EIN TEST");
        String fotoPath ="C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/CategoryImage/meatgrill.jpeg";
        File file = new File(fotoPath);
        String imageUrl = file.toURI().toURL().toString();
        FavoriteController favoriteController = new FavoriteController();
        favoriteController.addFavorit(imageUrl);
    }
}

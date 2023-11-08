package com.example.kochBuch;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    private AnchorPane parent;
    @FXML
    private Button btnChangeMode;

    @FXML
    private ImageView changeImage;
    private boolean isDarkMode = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnChangeMode.setOnMouseClicked(event -> {
            toggleDarkMode();
        });
    }

    private void toggleDarkMode() {
        if (isDarkMode) {
            parent.getStylesheets().remove(getClass().getResource("/com/example/kochBuch/cssStyle/darkMode.css").toExternalForm());
            parent.getStylesheets().add(getClass().getResource("/com/example/kochBuch/cssStyle/lightMode.css").toExternalForm());

            Image image = new Image(Objects.requireNonNull(getClass().getResource("/image/Icons/mond.png")).toExternalForm());
            changeImage.setImage(image);
            isDarkMode = false;
        } else {
            parent.getStylesheets().remove(getClass().getResource("/com/example/kochBuch/cssStyle/lightMode.css").toExternalForm());
            parent.getStylesheets().add(getClass().getResource("/com/example/kochBuch/cssStyle/darkMode.css").toExternalForm());

            Image image = new Image(Objects.requireNonNull(getClass().getResource("/image/Icons/brightness.png")).toExternalForm());

            changeImage.setImage(image);
            isDarkMode = true;
        }
    }



    @FXML
    private TextArea StartTexImage;

    @FXML
   private ImageView Startimage;

    @FXML
    private ImageView btnCategory;

    @FXML
    private ImageView btnFavorite;

    @FXML
    private ImageView btnMenu;

    @FXML
    private ImageView btnsearch;

    @FXML
    private TextField searchText;
    @FXML
    private StackPane StartstackPane;
    @FXML
    private Parent menuRoot;
    @FXML
    private boolean isMenuOpen = false;
    @FXML
    void OnCategoryClick(MouseEvent event) throws Exception{
        UserFxmlLoader.loadFXML("categoryView.fxml");
    }

    @FXML
    private AnchorPane Panevisibility;
    @FXML
    void OnMenuClick(MouseEvent event) throws Exception {

        if (isMenuOpen) {
            closeMenu();
            isMenuOpen = false;
            System.out.println("closeMenu() wurde aufgerufen");
        } else {
            openMenu();
            isMenuOpen = true;
        }
    }
    private void openMenu() {
        Panevisibility.setVisible(true);
    }
    private void closeMenu(){
        Panevisibility.setVisible(false);

    }

    @FXML
    void OnSearchKilick(MouseEvent event) {
        try {
            String Whereclause = searchText.getText();

            String sql = "SELECT foto, Zubereitungstext FROM Rezepte WHERE Zubereitungstext LIKE ?";
            ResultSet resultSet = SearchHelper.searchRecipe(sql, Whereclause);

            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        String fotoPath ="C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/CategoryImage/meatgrill.jpeg";
                                // resultSet.getString(foto);
                        String zubereitungstext = resultSet.getString("Zubereitungstext");
                        File file = new File(fotoPath);
                        String imageUrl = file.toURI().toURL().toString();
                        Startimage.setImage(new Image(imageUrl)); // Setze das Bild im ImageView
                        StartTexImage.setWrapText(true);
                        StartTexImage.setText(zubereitungstext); // Setze den Text im TextArea
                    } else {
                        // Kein Ergebnis gefunden ...
                    }

                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Handle SQL exceptions appropriately
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void OnFavoritClick(MouseEvent event) throws Exception {
        UserFxmlLoader.loadFXML("FavoritenView.fxml");

    }
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
        Stage stage = MainApplication.mainstage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartView.fxml"));
        Scene currentScene = new Scene(fxmlLoader.load());

        // Zweite Szene aus "registerView.fxml"
        FXMLLoader registerfxmlLoader = new FXMLLoader(MainApplication.class.getResource("registerView.fxml"));
        Scene registerView = new Scene(registerfxmlLoader.load());
        // StackPane, um beide Szenen übereinander zu legen
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(currentScene.getRoot(),registerView.getRoot());
        stage.setScene(new Scene(stackPane));
        stage.show();
    }

    @FXML
    void  OnSingInClick(MouseEvent event )throws  Exception{
        UserFxmlLoader.loadFXML("AnmeldenView.fxml");
    }



}


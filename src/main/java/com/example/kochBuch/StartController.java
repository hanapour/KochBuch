package com.example.kochBuch;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
    void OnCategoryClick(MouseEvent event) throws Exception {
        loadFXML("categoryView.fxml");
    }
    @FXML
    void OnMenuClick(MouseEvent event) throws Exception {
        loadFXML("MenuView.fxml");

    }

    private void loadFXML(String fxmlFileName) throws Exception {
        Stage stage = MainApplication.mainstage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFileName));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
                                // resultSet.getString();
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

    }}


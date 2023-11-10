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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.example.kochBuch.RandomNumberGenerator.generateRandomNumber;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StartController implements Initializable {
    private void loadFXML(String fxmlFileName) throws Exception {
        Stage stage = MainApplication.mainstage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFileName));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //String imagePath = getImageLocation();
        //Image image = new Image(getClass().getResourceAsStream(imagePath));
        //imageView.setImage(image);
    }

    @FXML
    private TextArea StartTexImage;

    /*@FXML
    private ImageView Startimage;*/


    @FXML
    private TextField searchText;

    @FXML
    private boolean isMenuOpen = false;

    @FXML
    void OnCategoryClick(MouseEvent event) throws Exception {
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

    private void closeMenu() {
        Panevisibility.setVisible(false);

    }

    @FXML
    void OnSearchKilick(MouseEvent event) {
        try {
            String sql = null;
            String Whereclause;
            if (searchText.getText().isEmpty()) {
                sql = "SELECT foto, Zubereitungstext FROM Rezepte WHERE RezeptID >= ? ";
                Whereclause = "(SELECT FLOOR(MAX(rezeptID) * RAND()) FROM Rezepte) LIMIT 1;";
            } else {
                Whereclause = searchText.getText();
                sql = "SELECT foto, Zubereitungstext FROM Rezepte WHERE Zubereitungstext LIKE ? ";
            }

            ResultSet resultSet = SearchHelper.searchRecipe(sql, Whereclause);

            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        String fotoPath = "C:/Users/wessa/IdeaProjects/KochBuch/src/main/resources/image/CategoryImage/meatgrill.jpeg";
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
    void OnKategorieClick(MouseEvent event) throws Exception {
        UserFxmlLoader.loadFXML("/com/example/kochBuch/categoryView.fxml");
    }

    protected static void StackPane_getChildren(String view2) throws Exception {
        Stage stage = MainApplication.mainstage;
        Scene currentScene = stage.getScene();
        // Zweite Szene aus "registerView.fxml"
        FXMLLoader registerfxmlLoader = new FXMLLoader(MainApplication.class.getResource(view2));
        Scene registerView = new Scene(registerfxmlLoader.load());
        // StackPane, um beide Szenen übereinander zu legen
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(currentScene.getRoot(), registerView.getRoot());
        stage.setScene(new Scene(stackPane));
        stage.show();
    }

    @FXML
    void OnSingUpClick(MouseEvent event) throws Exception {
        StackPane_getChildren("registerView.fxml");
    }

    @FXML
    void OnSingInClick(MouseEvent event) throws Exception {
        StackPane_getChildren("AnmeldenView.fxml");
    }

    //Ab hier beginnt der Code für das Gericht des Tages
    @FXML
    private ImageView Startimage;
    private final StringProperty imageLocation = new SimpleStringProperty();

    // Getter und Setter für die String-Property

    public String getImageLocation() {
        generateImagePath();
        return imageLocation.get();
    }

    public void setImageLocation(String path) {
        this.imageLocation.set(path);
    }

    public StringProperty imageLocationProperty() {
        return imageLocation;
    }
    int min = 0; // Mindestwert
    int max = 12; // Maximalwert (exklusiv)

    int randomNumber = generateRandomNumber(min, max);

    public void generateImagePath() {
        switch (randomNumber) {
            case 0:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0011.jpg");
                break;
            case 1:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0028.jpg");
                break;
            case 2:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/nachspeise/IMG_5689.jpg");
                break;
            case 3:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/nachspeise/IMG_5690.jpg");
                break;
            case 4:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0084.jpg");
                break;
            case 5:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0110.jpg");
                break;
            case 6:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0018.jpg");
                break;
            case 7:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0023.jpg");
                break;
            case 8:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0112.jpg");
                break;
            case 9:
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0075.jpg");
                break;
            case 10://vorspeise 1
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0040.jpg");
                break;
            case 11://vorspeise 2
                setImageLocation("@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0020.jpg");
                break;
            default:
                setImageLocation("@../../../image/EssenbilderKategorien/vegan1.jpg");
                break;
        }
    }

    /*public void generateImagePath() {
        String dynamicImagePath;
        switch (randomNumber) {
            case 0:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0011.jpg";
                Image image = new Image(dynamicImagePath);
                Startimage.setImage(image);
                break;
            case 1:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0028.jpg";
                Image image1 = new Image(dynamicImagePath);
                Startimage.setImage(image1);
                break;
            case 2:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/nachspeise/IMG_5689.jpg";
                Image image2 = new Image(dynamicImagePath);
                Startimage.setImage(image2);
                break;
            case 3:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/nachspeise/IMG_5690.jpg";
                Image image3 = new Image(dynamicImagePath);
                Startimage.setImage(image3);
                break;
            case 4:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0084.jpg";
                Image image4 = new Image(dynamicImagePath);
                Startimage.setImage(image4);
                break;
            case 5:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0110.jpg";
                Image image5 = new Image(dynamicImagePath);
                Startimage.setImage(image5);
                break;
            case 6:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0018.jpg";
                Image image6 = new Image(dynamicImagePath);
                Startimage.setImage(image6);
                break;
            case 7:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0023.jpg";
                Image image7 = new Image(dynamicImagePath);
                Startimage.setImage(image7);
                break;
            case 8:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0112.jpg";
                Image image8 = new Image(dynamicImagePath);
                Startimage.setImage(image8);
                break;
            case 9:
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0075.jpg";
                Image image9 = new Image(dynamicImagePath);
                Startimage.setImage(image9);
                break;
            case 10://vorspeise 1
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0040.jpg";
                Image image10 = new Image(dynamicImagePath);
                Startimage.setImage(image10);
                break;
            case 11://vorspeise 2
                dynamicImagePath ="@../../../../image/Timo%20Essen%20Bilder/IMG-20231031-WA0020.jpg";
                Image image11 = new Image(dynamicImagePath);
                Startimage.setImage(image11);
                break;
            default:
                dynamicImagePath ="@../../../image/EssenbilderKategorien/vegan1.jpg";
                Image image12 = new Image(dynamicImagePath);
                Startimage.setImage(image12);
                break;
        }
    }*/

    @FXML
    void OnGerichtDesTagesClick(MouseEvent event) throws Exception {
        System.out.println(randomNumber);
        //System.out.println(getImageLocation());
        switch (randomNumber) {
            case 0:
                loadFXML("/com/example/kochBuch/GerichteView/fleisch1View.fxml");
                break;
            case 1:
                loadFXML("/com/example/kochBuch/GerichteView/fleisch2View.fxml");
                break;
            case 2:
                loadFXML("/com/example/kochBuch/GerichteView/nachspeise1View.fxml");
                break;
            case 3:
                loadFXML("/com/example/kochBuch/GerichteView/nachspeise2View.fxml");
                break;
            case 4:
                loadFXML("/com/example/kochBuch/GerichteView/persisch1View.fxml");
                break;
            case 5:
                loadFXML("/com/example/kochBuch/GerichteView/persisch2View.fxml");
                break;
            case 6:
                loadFXML("/com/example/kochBuch/GerichteView/seafood1View.fxml");
                break;
            case 7:
                loadFXML("/com/example/kochBuch/GerichteView/seafood2View.fxml");
                break;
            case 8:
                loadFXML("/com/example/kochBuch/GerichteView/vegan1View.fxml");
                break;
            case 9:
                loadFXML("/com/example/kochBuch/GerichteView/vegan2View.fxml");
                break;
            case 10:
                loadFXML("/com/example/kochBuch/GerichteView/vorspeise1View.fxml");
                break;
            case 11:
                loadFXML("/com/example/kochBuch/GerichteView/vorspeise2View.fxml");
                break;
            default:
                loadFXML("/com/example/kochBuch/GerichteView/KategorieView.fxml");
                break;
        }
    }

}


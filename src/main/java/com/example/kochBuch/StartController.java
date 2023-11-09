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
    private AnchorPane startView;

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
            String sql = null;
            String Whereclause ;
            if(searchText.getText().isEmpty()){
                sql= "SELECT foto, Zubereitungstext FROM Rezepte WHERE RezeptID >= ? ";
                Whereclause="(SELECT FLOOR(MAX(rezeptID) * RAND()) FROM Rezepte) LIMIT 1;";
            }else { Whereclause= searchText.getText();
                 sql = "SELECT foto, Zubereitungstext FROM Rezepte WHERE Zubereitungstext LIKE ? ";
            }

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
    protected static void StackPane_getChildren(String view2) throws Exception{
        Stage stage = MainApplication.mainstage;
        Scene currentScene = stage.getScene();
        // Zweite Szene aus "registerView.fxml"
        FXMLLoader registerfxmlLoader = new FXMLLoader(MainApplication.class.getResource(view2));
        Scene registerView = new Scene(registerfxmlLoader.load());
        // StackPane, um beide Szenen übereinander zu legen
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(currentScene.getRoot(),registerView.getRoot());
        stage.setScene(new Scene(stackPane));
        stage.show();
    }

    @FXML
    void OnSingUpClick(MouseEvent event) throws Exception {
        StackPane_getChildren("registerView.fxml");
    }

    @FXML
    void  OnSingInClick(MouseEvent event )throws  Exception{
        StackPane_getChildren("AnmeldenView.fxml");
    }
//Ab hier beginnt der Code für das Gericht des Tages
    int min = 0; // Mindestwert
    int max = 12; // Maximalwert (exklusiv)

    int randomNumber = generateRandomNumber(min, max);

    /*void generateImage(){
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
      }*/
    @FXML
    void OnGerichtDesTagesClick(MouseEvent event) throws Exception {
        System.out.println(randomNumber);
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


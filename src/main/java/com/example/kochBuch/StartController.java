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

public class StartController extends FavoriteController implements Initializable {



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
    int  RezeptID;
    @FXML
    void OnSearchKilick() {
        try {
            String sql = null;
            String Whereclause ;
            if(searchText.getText().isEmpty()){
                sql= "SELECT SUBSTRING_INDEX(Foto,'KochBuch/', -1) AS Foto , Zubereitungstext, RezeptID \n" +
                        "FROM Rezepte \n" +
                        "WHERE Rezepte.Foto IS NOT NULL  AND Rezepte.RezeptID<> "+RezeptID+" AND RezeptID >=? ";
                Whereclause="(SELECT FLOOR(MAX(rezeptID) * RAND()) FROM Rezepte WHERE RezeptID ) LIMIT 1;";
        }else { Whereclause= searchText.getText();
                sql = "SELECT SUBSTRING_INDEX(Foto,'KochBuch', -1) AS Foto, Zubereitungstext, RezeptID FROM Rezepte WHERE   Rezepte.Foto IS NOT NULL AND Zubereitungstext LIKE '%' ? '%'";
            }
            ResultSet resultSet = DatabaseManipulation.statement(sql, Whereclause);
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        String fotoPath ="@.."+ resultSet.getString("Foto");
                        String zubereitungstext = resultSet.getString("Zubereitungstext");
                        RezeptID =resultSet.getInt("RezeptID");
                       File file = new File(fotoPath);
                        String image = file.toURI().toURL().toString();
                        String userFoto =image.replace("@..","");
                        Startimage.setImage(new Image(userFoto));
                        StartTexImage.setWrapText(true);
                        StartTexImage.setText(zubereitungstext);
                    } else {
                        // Kein Ergebnis gefunden ...
                    }
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
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
    @FXML
    public void onFavoritenButtonClicked(MouseEvent event) throws SQLException {
        FavoriteManipulation favoriteManipulation = new FavoriteManipulation();
        favoriteManipulation.insertOrDelet(RezeptID);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OnSearchKilick();
    }
}


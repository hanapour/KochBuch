package com.example.kochBuch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
public class FavoriteController implements Initializable {
    @FXML
    private ScrollPane imageScrollPane;
    @FXML
    public TilePane TilePaneFavorit;
    @FXML
    private HBox favoritenbox;

    private final List<Integer> listRezeptid = new ArrayList<>();
    public void OnBackClick(MouseEvent event) throws Exception {
        UserFxmlLoader.loadFXML("StartView.fxml");
    }
    @FXML
    protected void GetFavoriten() throws MalformedURLException, SQLException {

        List<Integer> listRezeptid = new ArrayList<>();

        List<Integer> favoritstat =new ArrayList<>();

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connectToDatabase();
        String sql = "SELECT DISTINCT SUBSTRING_INDEX(Foto, 'KochBuch', -1) AS Foto,rezepte.RezeptID,rezepte.Zubereitungstext,rezepte.Rezeptname from rezepte\n" +
                "inner join favoriten on favoriten.RezeptID = rezepte.RezeptID WHERE favoriten.BenutzerID IS NULL ;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

            String allFavoritenRezeptId = "SELECT DISTINCT SUBSTRING_INDEX(Foto, 'KochBuch', -1) AS Foto,rezepte.RezeptID  from rezepte\n" +
                    "inner join favoriten on favoriten.RezeptID = rezepte.RezeptID WHERE favoriten.BenutzerID IS NULL ORDER BY favoriten.FavoritenID DESC;";
        PreparedStatement favoritenStatement = connection.prepareStatement(allFavoritenRezeptId);
        ResultSet favoritenResult = favoritenStatement.executeQuery(allFavoritenRezeptId);
        while (favoritenResult.next()) {
            int rezeptID = favoritenResult.getInt("RezeptID");
            favoritstat.add(rezeptID);
        }

        List<List<String>> rezeptInfos = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String fotoPath = resultSet.getString("Foto");
                String toUserFoto = "@.."+fotoPath;
                int id = resultSet.getInt("RezeptID");
                String zubereitungstext= resultSet.getString("Zubereitungstext");
                String titelnames = resultSet.getString("Rezeptname");
                listRezeptid.add(id);
                List<String> rezeptInfo = new ArrayList<>();
                rezeptInfo.add(toUserFoto);//index 0
                rezeptInfo.add(zubereitungstext); // index 1
                rezeptInfo.add(String.valueOf(id)); // index 2
                rezeptInfo.add(titelnames); //index 3
                rezeptInfos.add(rezeptInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Stage Popupstage= new Stage();
        for (List<String>retzepinfo:rezeptInfos) {
            File file = new File(retzepinfo.get(0));
            String imageUrl = file.toURI().toURL().toString();
            String userImage = imageUrl.replace("@..", "");
            Image images = new Image(userImage);
            ImageView mainImage = new ImageView(images);
            mainImage.setPreserveRatio(false);
            mainImage.setFitWidth(385);
            mainImage.setFitHeight(300);
            // Herz hinzufügen
            String imagePath = (favoritstat.contains(Integer.parseInt (retzepinfo.get(2)))) ? "@../src/main/resources/image/HerzRot.png" : "@../src/main/resources/image/herz.png";
            File heart = new File(imagePath);
            String RotHeart = heart.toURI().toURL().toString();
            String userFoto = RotHeart.replace("@..", "");
            Image heartImages = new Image(userFoto);
            ImageView heartImageView = new ImageView(heartImages);
            heartImageView.setFitWidth(25);
            heartImageView.setFitHeight(25);

            VBox mainvbox = new VBox();
            TextField textField = new TextField();
            textField.setText(retzepinfo.get(3));
            textField.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
            textField.setEditable(false);
            mainvbox.getChildren().addAll(textField,mainImage,heartImageView);

            mainImage.setOnMouseClicked( (MouseEvent mouseEvent) -> {
                //  neue Foto und ein TextField
                // Foto hinzufügen
                ImageView newImageView = new ImageView(images);
                newImageView.setPreserveRatio(false);
                newImageView.setFitWidth(400);
                newImageView.setFitHeight(400);
                TextArea textArea = new TextArea();
                textArea.setWrapText(true);
                textArea.setText(retzepinfo.get(1));
                VBox Popup =new VBox();
                Popup.getChildren().addAll(textField,newImageView,heartImageView,textArea);
                // Popup anzeigen
                Scene Popupscene = new Scene(Popup, 400, 600);
                Popupstage.setScene(Popupscene);

                if (Popupstage.isShowing()) {
                    Popupstage.close();
                }Popupstage.show();
                mainvbox.getChildren().clear();
                mainvbox.getChildren().addAll(textField,mainImage,heartImageView);
                // Klick war außerhalb der main stage, schließe das Popup
                // if (!((mouseEvent.getTarget() instanceof Stage)))Popupstage.show();
            });
            MainApplication.mainstage.setOnCloseRequest(event -> {
                Popupstage.close();
            });

            heartImageView.setOnMouseClicked((MouseEvent event1) -> {
                FavoriteManipulation favoriteManipulation = new FavoriteManipulation();

                try {
                    favoriteManipulation.insertOrDelet(Integer.parseInt (retzepinfo.get(2)));
                    UserFxmlLoader.loadFXML("FavoritenView.fxml");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                //UserFxmlLoader.loadFXML("FavoritenView.fxml");

            });

            TilePaneFavorit.getChildren().add(mainvbox);
        }
        TilePaneFavorit.setHgap(10);
        TilePaneFavorit.setVgap(10);
        TilePaneFavorit.layout();
        imageScrollPane = new ScrollPane();
        imageScrollPane.setContent(TilePaneFavorit);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       try {
            GetFavoriten();
        } catch (MalformedURLException e) {
           throw new RuntimeException(e);
       } catch (SQLException e) {
          //  throw new RuntimeException(e);
        }

    }
}

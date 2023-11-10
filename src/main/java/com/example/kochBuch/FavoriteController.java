package com.example.kochBuch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
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
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connectToDatabase();
        String sql = "SELECT SUBSTRING_INDEX(Foto, 'KochBuch', -1) AS Foto,rezepte.RezeptID  from rezepte\n" +
                "inner join favoriten on favoriten.RezeptID = rezepte.RezeptID;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> fotoPaths = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String fotoPath = resultSet.getString("Foto");
                String toUserFoto = "@.."+fotoPath;
                int id = resultSet.getInt("RezeptID");
                listRezeptid.add(id);
                fotoPaths.add(toUserFoto);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (String image : fotoPaths) {
            File file = new File(image);
            String imageUrl = file.toURI().toURL().toString();
           String userImage =imageUrl.replace("@..","");
            Image images = new Image(userImage);
            ImageView imageView = new ImageView(images);
            imageView.setPreserveRatio(false);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
            TilePaneFavorit.getChildren().add(imageView);
            TilePaneFavorit.setOrientation(Orientation.HORIZONTAL);
            // Abstand zwischen den Bildern
            TilePaneFavorit.setHgap(10);
            TilePaneFavorit.setVgap(10);
            TilePaneFavorit.layout();
            imageScrollPane = new ScrollPane();
            imageScrollPane.setContent(TilePaneFavorit);
        }
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

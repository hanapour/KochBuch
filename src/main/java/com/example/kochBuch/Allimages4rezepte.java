package com.example.kochBuch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

import static com.example.kochBuch.StartController.Whereclause;

public class Allimages4rezepte implements Initializable {
    @FXML
    private TilePane TilePaneRezepte;
    @FXML
    private ScrollPane imageScrollPane;
    private final List<Integer> listRezeptid = new ArrayList<>();
    @FXML
    public void OnBackClick(MouseEvent event) throws Exception {
        UserFxmlLoader.loadFXML("StartView.fxml");}
    @FXML
    protected void GetRezeptFotos() throws SQLException, MalformedURLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connectToDatabase();
        String  sql = "SELECT SUBSTRING_INDEX(rezepte.Foto,'KochBuch/', -1) AS Foto , rezepte.Zubereitungstext, rezepte.RezeptID \n" +
                "FROM rezepte \n" +
                "left join rezeptezutaten ON rezeptezutaten.RezeptID =rezepte.RezeptID\n" +
                "left join zutaten ON zutaten.ZutatenID =rezeptezutaten.ZutatenID\n" +
                "WHERE Rezepte.Foto IS NOT NULL AND rezepte.Zubereitungstext LIKE '%' '"+Whereclause+"'  '%' OR zutaten.Zutatenname LIKE '%' '"+Whereclause+"' '%' OR rezepte.Rezeptname LIKE '%' '"+Whereclause+"' '%';";
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
            imageView.setFitWidth(380);
            imageView.setFitHeight(350);
            TilePaneRezepte.getChildren().add(imageView);
            TilePaneRezepte.setOrientation(Orientation.HORIZONTAL);
            // Abstand zwischen den Bildern
            TilePaneRezepte.setHgap(10);
            TilePaneRezepte.setVgap(10);
            TilePaneRezepte.layout();
            imageScrollPane = new ScrollPane();
            imageScrollPane.setContent(TilePaneRezepte);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            GetRezeptFotos();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            //  throw new RuntimeException(e);
        }
    }
}

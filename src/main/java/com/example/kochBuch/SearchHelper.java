package com.example.kochBuch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.net.MalformedURLException;
import java.io.File;
import javafx.scene.image.Image;

public class SearchHelper {
    public static ResultSet searchRecipe(String sql, String Whereclause) {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.connectToDatabase();
            if (Whereclause == null) {
                Whereclause = "";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + Whereclause + "%");
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


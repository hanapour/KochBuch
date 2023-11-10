package com.example.kochBuch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteManipulation {
    void insertOrDelet(int RezeptID) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connectToDatabase();

        String sql;
        String searchStatement = "SELECT * FROM favoriten WHERE RezeptID = ?";

        try (PreparedStatement searchID = connection.prepareStatement(searchStatement)) {
            searchID.setInt(1, RezeptID);

            try (ResultSet resultSet = searchID.executeQuery()) {
                if (resultSet.next()) {
                    // Die RezeptID ist bereits in favoriten vorhanden, also lösche den Datensatz
                    sql = "DELETE FROM favoriten WHERE RezeptID = ?";
                } else {
                    // Die RezeptID ist noch nicht in favoriten vorhanden, also füge den Datensatz ein
                    sql = "INSERT INTO favoriten (RezeptID) VALUES (?)";
                }
            }
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, RezeptID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}


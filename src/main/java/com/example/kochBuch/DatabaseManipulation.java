package com.example.kochBuch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManipulation {
    public static ResultSet statement(String sql, String Whereclause) {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.connectToDatabase();
            if (Whereclause == null) {
                Whereclause = "";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,  Whereclause );
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ResultSet statementINT(String sql, int Whereclause) {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.connectToDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,  Whereclause );
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



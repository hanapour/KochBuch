package com.example.kochBuch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // MySQL-Datenbankverbindungsinformationen
    private static final String DB_URL = "jdbc:mysql://localhost:3306/kochbuch";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";


    // Methode zum Herstellen der Verbindung zur MySQL-Datenbank
    public Connection connectToDatabase() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Verbindung zur MySQL-Datenbank hergestellt.");
            return connection;
        } catch (SQLException e) {
            System.err.println("Fehler beim Herstellen der Verbindung zur MySQL-Datenbank: " + e.getMessage());
            throw e;
        }

        //
    }
}

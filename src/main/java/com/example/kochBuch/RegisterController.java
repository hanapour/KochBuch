package com.example.kochBuch;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private MouseEvent event;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button CloseButton;

    @FXML
    private TextField ConfirmTextField;

    @FXML
    private TextField FirstnameTextField;

    @FXML
    private TextField LastnameTextField;

    @FXML
    private AnchorPane Pane2;

    @FXML
    private TextField PasswordTextField;

    @FXML
    private Button RegisterButton;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private ImageView schieldimageView;
    @FXML
    private TextField AnmeldenPasswordTextField;

    @FXML
    private TextField AnmeldenUsernameTextField;


    @FXML
    void OnCloseClick(MouseEvent event) throws Exception {
        CategoryController categoryController = new CategoryController();
        categoryController.loadStartPage(event);
    }

    @FXML
    void OnRegisterClick(MouseEvent event) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connectToDatabase();

        try {
            String Vorname = FirstnameTextField.getText();
            String Nachname = LastnameTextField.getText();
            String Benutzername = UsernameTextField.getText();
            String Passwort = PasswordTextField.getText();
            String confirm = ConfirmTextField.getText();

            if (!Passwort.equals(confirm)) {
                // Passwort und Bestätigung stimmen nicht überein
                System.out.println("Passwort und Bestätigung stimmen nicht überein!");
                return;
            }

            String insertQuery = "INSERT INTO Benutzer (Vorname, Nachname, Benutzername, Passwort) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, Vorname);
            preparedStatement.setString(2, Nachname);
            preparedStatement.setString(3,Benutzername );
            preparedStatement.setString(4, Passwort);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Daten erfolgreich eingefügt
                System.out.println("Daten erfolgreich eingefügt!");
            } else {
                // Einfügen der Daten fehlgeschlagen
                System.out.println("Einfügen der Daten fehlgeschlagen!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void OnAnmeldenClick(MouseEvent event) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.connectToDatabase();
        try {
            String Benutzername = AnmeldenUsernameTextField.getText();
            String Passwort = AnmeldenPasswordTextField.getText();

            String SelectQuery = "SELECT count(*) FROM Benutzer WHERE Benutzername = ? AND Passwort = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SelectQuery);
            preparedStatement.setString(1, Benutzername);
            preparedStatement.setString(2, Passwort);

            // Führe die SQL-Abfrage aus und erhalte das Ergebnis
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1); // Hole den Wert der ersten Spalte (count)
                if (count > 0) {
                    // Benutzerdaten sind korrekt, der Benutzer ist in der Datenbank vorhanden
                    System.out.println("Anmeldung erfolgreich!");
                } else {
                    // Benutzerdaten sind nicht korrekt oder der Benutzer existiert nicht
                    System.out.println("Anmeldung fehlgeschlagen!");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

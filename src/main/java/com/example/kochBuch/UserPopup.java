package com.example.kochBuch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserPopup {
    static Stage newstage;
    protected static void loadOnNewStage(String fxmlFileName) throws IOException {
        newstage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFileName));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root,520,520);
        newstage.setScene(scene);
        if (newstage.isShowing()) {
            newstage.close();
        }newstage.show();
        MainApplication.mainstage.setOnCloseRequest(event -> {newstage.close();});
    }
}

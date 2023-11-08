package com.example.kochBuch;

import javafx.scene.input.MouseEvent;

import java.net.MalformedURLException;

// FavoritenButtonListener.java
public interface FavoritenButtonListener {
    void onFavoritenButtonClicked(MouseEvent event) throws MalformedURLException;
    //boolean isFavorit() ;
}


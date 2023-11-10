package com.example.kochBuch;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class  ImageUrlfromFolder {
    public static String[] getAllImageUrls(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Das Verzeichnis existiert nicht oder ist kein Verzeichnis.");
            return new String[0];
        }

        File[] files = directory.listFiles();
        List<String> imageUrls = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String imageUrl = file.toURI().toString();

                    imageUrls.add(imageUrl);
                }
            }
        }

        return imageUrls.toArray(new String[0]);
    }

}


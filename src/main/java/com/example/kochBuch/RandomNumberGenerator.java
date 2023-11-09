package com.example.kochBuch;
import java.util.Random;

public class RandomNumberGenerator {
    public static int generateRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Maximalwert muss größer als Mindestwert sein");
        }

        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}

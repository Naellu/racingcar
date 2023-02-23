package org.example.model;

import java.util.Random;

public class RandomNumber {

    private static final int NUM_LIMIT = 9;

    Random random = new Random();

    public int initNumber() {
        return random.nextInt(NUM_LIMIT);
    }
}

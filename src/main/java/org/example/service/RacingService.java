package org.example.service;

import org.example.model.RandomNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingService implements Running {

    private static final int PLUS_POSITION = 1;
    private static final int ZERO = 0;
    private static final int NUM_FOUR = 4;

    private Map<String, Integer> PlayerConditions = new HashMap<>();
    private Map<String, Integer> PlayerRandomNumber = new HashMap<>();
    List<String> winner = new ArrayList<>();

    public Map<String, Integer> getPlayerConditions() {
        return PlayerConditions;
    }

    @Override
    public void defaultPlayerMap(List<String> car) {
        for (int i = 0; i < car.size(); i++) {
            PlayerConditions.put(car.get(i), ZERO);
        }
    }

    @Override
    public void makeRandomNumOfCarName(List<String> car, RandomNumber randomNumber, int turn) {
        for (int i = 0; i < car.size(); i++) {
            PlayerRandomNumber.put(car.get(i), randomNumber.initNumber());
        }
        isOverNumberfour();
    }

    @Override
    public void isOverNumberfour() {
        for (String key : PlayerRandomNumber.keySet()) {
            if (PlayerRandomNumber.get(key) >= NUM_FOUR) {
                PlayerConditions.put(key, PlayerConditions.get(key) + PLUS_POSITION);
            }
        }
    }

    @Override
    public List<String> isWinner() {
        int max = Collections.max(PlayerConditions.values());
        for (String key : PlayerConditions.keySet()) {
            if (PlayerConditions.get(key) == max) {
                winner.add(key);
            }
        }
        return winner;
    }

}

package org.example.service;

import org.example.model.RandomNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    // car로 넘어온 키(자동차 이름)를 그대로 반환하기 위해 Function.identity() 사용
    @Override
    public void defaultPlayerMap(List<String> car) {
        PlayerConditions = car.stream()
                .collect(Collectors.toMap(Function.identity(), defaultNum -> ZERO));
    }

    @Override
    public void makeRandomNumOfCarName(List<String> car, RandomNumber randomNumber) {
        PlayerRandomNumber = car.stream()
                .collect(Collectors.toMap(Function.identity(), value -> randomNumber.initNumber()));
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

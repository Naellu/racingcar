package org.example.service;

import org.example.model.RandomNumber;

import java.util.List;

public interface Running {
    void defaultPlayerMap(List<String> car);
    void makeRandomNumOfCarName(List<String> car, RandomNumber randomNumber, int turn);
    void isOverNumberfour();
    List<String> isWinner();
}

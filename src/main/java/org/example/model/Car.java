package org.example.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public List<String> isMoreName(Car car) {
        return Stream.of(car.getName().split(","))
                .collect(Collectors.toList());
    }

}

package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String carName = car.getName();
        String[] divideCarName = carName.split(",");
        List<String> haveEachName = new ArrayList<>(Arrays.asList(divideCarName));
        return haveEachName;
    }
    
}

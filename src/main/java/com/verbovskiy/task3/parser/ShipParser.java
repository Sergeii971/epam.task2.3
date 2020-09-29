package com.verbovskiy.task3.parser;

import com.verbovskiy.task3.entity.Ship;

import java.util.*;

public class ShipParser {
    private final String DELIMITER = " ";

    public Ship parseShipData(String line) {
        List<Double> parsedData = new ArrayList<>();
        List<String> shipData = Arrays.asList(line.split(DELIMITER));

        return createShip(shipData);
    }

    private Ship createShip(List<String> shipData) {
        String name = shipData.get(0);
        int containerNumber = Integer.parseInt(shipData.get(1));
        int containerCapacity = Integer.parseInt(shipData.get(2));

        return new Ship(name, containerNumber, containerCapacity);
    }
}

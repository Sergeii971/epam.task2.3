package com.verbovskiy.task3.creator;

import com.verbovskiy.task3.entity.Ship;
import com.verbovskiy.task3.parser.ShipParser;
import com.verbovskiy.task3.reader.DataReader;

import java.util.ArrayList;
import java.util.List;

public class ShipCreator {
    public List<Ship> createShipsFile(String filename) {
        DataReader reader = new DataReader();
        List<String> lines = reader.readFileData(filename);
        ShipParser parser = new ShipParser();
        List<Ship> ships = new ArrayList<>();

        for (String line : lines) {
            Ship ship = parser.parseShipData(line);
            ships.add(ship);
        }
        return ships;
    }
}

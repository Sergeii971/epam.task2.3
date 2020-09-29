package com.verbovskiy.task3.main;

import com.verbovskiy.task3.creator.ShipCreator;
import com.verbovskiy.task3.entity.Ship;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final String fileName = "data/ship.txt";
        ShipCreator creator = new ShipCreator();
        List<Ship> ships = creator.createShipsFile(fileName);
        try {
            for (Ship ship : ships) {
                Future<Ship> future = new FutureTask<>(ship);
                Thread thread = new Thread((Runnable) future);
                thread.start();
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}

package com.verbovskiy.task3.entity.state.impl;

import com.verbovskiy.task3.entity.Berth;
import com.verbovskiy.task3.entity.Port;
import com.verbovskiy.task3.entity.Ship;
import com.verbovskiy.task3.entity.state.ShipState;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ArrivingState implements ShipState {
    private final Logger logger = LogManager.getLogger(ArrivingState.class);

    @Override
    public void arriveBerth(Ship ship) {
        Port port = Port.getInstance();
        Berth berth = port.arriveToBerth();
        ship.setBerth(berth);
        logger.log(Level.INFO, "Ship " + ship.getName() + " is in Port, Berth " + berth.getBerthId());
        ship.setShipState(new UnloadingState());
    }

    @Override
    public void unloadContainers(Ship ship) {
        logger.log(Level.WARN, "Can`t use this method");
    }

    @Override
    public void loadContainers(Ship ship) {
        logger.log(Level.WARN, "Can`t use this method");
    }

    @Override
    public void departBerth(Ship ship) {
        logger.log(Level.WARN, "Can`t use this method");
    }
}

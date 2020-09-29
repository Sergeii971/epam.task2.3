package com.verbovskiy.task3.entity.state.impl;

import com.verbovskiy.task3.entity.Berth;
import com.verbovskiy.task3.entity.Port;
import com.verbovskiy.task3.entity.Ship;
import com.verbovskiy.task3.entity.state.ShipState;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DepartingState implements ShipState {
    private final Logger logger = LogManager.getLogger(DepartingState.class);

    @Override
    public void arriveBerth(Ship ship) {
        logger.log(Level.WARN, "Can`t use this method");
    }

    @Override
    public void departBerth(Ship ship) {
        Berth berth = ship.getBerth();

        if (berth != null) {
            Port port = Port.getInstance();
            port.departFromBerth(berth);
            ship.setBerth(null);
            logger.log(Level.INFO, "Ship " + ship.getName() + " left Port from the Berth " + berth.getBerthId());
        }
       ship.setShipState(new ArrivingState());
    }

    @Override
    public void loadContainers(Ship ship) {
        logger.log(Level.WARN, "Can`t use this method");
    }

    @Override
    public void unloadContainers(Ship ship) {
        logger.log(Level.WARN, "Can`t use this method");
    }
}

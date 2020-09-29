package com.verbovskiy.task3.entity.state;

import com.verbovskiy.task3.entity.Ship;

public interface ShipState {
    void arriveBerth(Ship ship);

    void unloadContainers(Ship ship);

    void loadContainers(Ship ship);

    void departBerth(Ship ship);
}

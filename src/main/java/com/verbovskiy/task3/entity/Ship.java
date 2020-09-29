package com.verbovskiy.task3.entity;

import com.verbovskiy.task3.entity.state.ShipState;
import com.verbovskiy.task3.entity.state.impl.ArrivingState;

import java.util.concurrent.Callable;

public class Ship implements Callable<Ship> {
    private String name;
    private int containerNumber;
    private int containerCapacity;
    private Berth berth;
    private ShipState shipState;


    public Ship(String name, int containerNumber, int containerCapacity) {
        this.name = name;
        this.containerNumber = containerNumber;
        this.containerCapacity = containerCapacity;
        this.shipState = new ArrivingState();
    }

    public String getName() {
        return name;
    }

    public Ship setName(String name) {
        this.name = name;
        return this;
    }

    public int getContainerNumber() {
        return containerNumber;
    }

    public Ship setContainerNumber(int containerNumber) {
        this.containerNumber = containerNumber;
        return this;
    }

    public int getContainerCapacity() {
        return containerCapacity;
    }

    public Ship setContainerCapacity(int containerCapacity) {
        this.containerCapacity = containerCapacity;
        return this;
    }

    public Berth getBerth() {
        return berth;
    }

    public void setBerth(Berth berth) {
        this.berth = berth;
    }

    public ShipState getShipState() {
        return shipState;
    }

    public void setShipState(ShipState shipState) {
        this.shipState = shipState;
    }

    public boolean addContainer() {
        boolean result = false;

        if (containerNumber < containerCapacity) {
            containerNumber++;
            result = true;
        }
        return result;
    }

    public boolean removeContainer() {
        boolean result = false;

        if (containerNumber > 0) {
            containerNumber--;
            result = true;
        }
        return result;
    }

    @Override
    public Ship call() {
        shipState.arriveBerth(this);
        shipState.unloadContainers(this);
        shipState.loadContainers(this);
        shipState.departBerth(this);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Ship ship = (Ship) obj;

        if (name == null) {
            if (ship.name != null) {
                return false;
            }
        } else {
            if (!name.equals(ship.name)) {
                return false;
            }
        }

        if (containerNumber != ship.containerNumber) {
            return false;
        }
        if (containerCapacity != ship.containerCapacity) {
            return false;
        }
        if (berth == null) {
            if (ship.berth != null) {
                return false;
            }
        } else {
            if (!berth.equals(ship.berth)) {
                return false;
            }
        }
        if (shipState == null) {
            if (ship.shipState != null) {
                return false;
            }
        } else {
            if (!shipState.equals(ship.shipState)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + containerNumber;
        result = 31 * result + containerCapacity;
        result = 31 * result + (berth == null ? 0 : berth.hashCode());
        result = 31 * result + (shipState == null ? 0 : shipState.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" ");
        stringBuilder.append(containerNumber);
        stringBuilder.append(" ");
        stringBuilder.append(containerCapacity);
        stringBuilder.append(" ");
        stringBuilder.append(shipState.getClass().getSimpleName());
        return stringBuilder.toString();
    }
}

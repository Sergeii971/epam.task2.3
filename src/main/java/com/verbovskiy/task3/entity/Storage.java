package com.verbovskiy.task3.entity;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class Storage {
    private static final Logger logger = LogManager.getLogger(Storage.class);
    private static final int STORAGE_CAPACITY = 8;
    private static Storage instance = new Storage();
    private AtomicInteger containersInStorage = new AtomicInteger();

    private Storage() {
    }

    public static Storage getInstance() {
        return instance;
    }

    public AtomicInteger getContainersInStorage() {
        return containersInStorage;
    }

    public Storage setContainersInStorage(AtomicInteger containersInStorage) {
        this.containersInStorage = containersInStorage;
        return this;
    }

    public int getStorageCapacity() {
        return STORAGE_CAPACITY;
    }

    public boolean isFull() {
        return containersInStorage.get() == STORAGE_CAPACITY;
    }

    public boolean isEmpty() {
        return containersInStorage.get() <= 0;
    }

    public void unload(Ship ship) {
        while (ship.removeContainer() && !isFull()) {
            containersInStorage.incrementAndGet();
            logger.log(Level.INFO, "Containers removed from ship, number of containers in storage - " +
                    containersInStorage);
        }
        if (isFull()) {
            logger.log(Level.INFO, "storage is full");
        }
    }

    public void load(Ship ship) {
        while (ship.addContainer() && !isEmpty()) {
            containersInStorage.decrementAndGet();
            logger.log(Level.INFO, "Containers added to ship, number of containers in storage - "
                    + containersInStorage);
        }
        if (isEmpty()) {
            logger.log(Level.INFO, "storage is empty");
        }
    }
}

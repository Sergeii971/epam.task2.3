package com.verbovskiy.task3.entity;

public class Berth {
    private int berthId;

    public Berth(int berthId) {
        this.berthId = berthId;
    }

    public int getBerthId() {
        return berthId;
    }

    public Berth setBerthId(int pierId) {
        this.berthId = pierId;
        return this;
    }

    public void unloadToStorage(Ship ship) {
        Storage storage = Storage.getInstance();
        storage.unload(ship);
    }

    public void loadFromStorage(Ship ship) {
        Storage storage = Storage.getInstance();
        storage.load(ship);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Berth berth = (Berth) o;

        return (berthId == berth.berthId);
    }

    @Override
    public int hashCode() {
        return berthId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(berthId);
        return builder.toString();
    }
}

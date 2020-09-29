package com.verbovskiy.task3.entity;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static final Port instance = new Port();
    private static final int BERTH_NUMBER = 4;
    private Deque<Berth> freeBerth;
    private Queue<Berth> busyBerth;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private static Logger logger = LogManager.getLogger(Port.class);


    private Port() {
        this.freeBerth = new ArrayDeque<>();
        this.busyBerth = new LinkedList<>();
        for (int i = 0; i < BERTH_NUMBER; i++) {
            freeBerth.add(new Berth(i + 1));
        }
    }

    public static Port getInstance() {
        return instance;
    }

    public Berth arriveToBerth() {
        Berth berth = null;
        try {
            lock.lock();
            while (freeBerth.isEmpty()) {
                condition.await();
            }
            berth = freeBerth.poll();
            busyBerth.offer(berth);
        } catch (InterruptedException e) {
            logger.log(Level.WARN, e);
        } finally {
            lock.unlock();
        }
        return berth;
    }

    public void departFromBerth(Berth berth) {
        try {
            lock.lock();
            freeBerth.offer(berth);
            busyBerth.remove();
        } finally {
            condition.signal();
            lock.unlock();
        }
    }
}

package com.algmachine.service.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Pessimistic {
    private int value;

    public synchronized void add() {
        this.value++;
    }

    private ReentrantLock lock = new ReentrantLock();

    public void addValueWithLock() {
        lock.lock();
        value++;
        lock.unlock();
    }
}

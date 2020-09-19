package com.algmachine.service.design_pattern.singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public synchronized static ThreadSafeSingleton getInstance() {
        if (null == instance) {
            instance = new ThreadSafeSingleton();
            return instance;
        }
        return instance;
    }
}

package com.algmachine.service.design_pattern.singleton;

public class LazyLoaderSingleton {
    private LazyLoaderSingleton() {
    }

    private static class LazyHolder {
        private static final LazyLoaderSingleton instance = new LazyLoaderSingleton();
    }

    public static LazyLoaderSingleton getInstance() {
        return LazyHolder.instance;
    }
}

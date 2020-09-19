package com.algmachine.service.design_pattern.singleton;

public class SimpleSingleton {
    private static SimpleSingleton instance = new SimpleSingleton();

//    static {
//        //TODO init when the object is complex
//        instance = new SimpleSingleton();
//    }

    private SimpleSingleton() {

    }

    public static SimpleSingleton getInstance() {
        return instance;
    }
}

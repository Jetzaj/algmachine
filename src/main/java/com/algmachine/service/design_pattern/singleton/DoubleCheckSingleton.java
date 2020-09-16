package com.algmachine.service.design_pattern.singleton;

public class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        //check if it is created
        if (null == instance) {
            //synchronize creation block
            synchronized (DoubleCheckSingleton.class) {
                //double check if it is created
                if (null == instance) {
                    instance = new DoubleCheckSingleton();
                    return instance;
                }
            }
        }
        return instance;
    }
}

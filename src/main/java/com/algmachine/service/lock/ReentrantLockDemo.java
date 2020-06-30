package com.algmachine.service.lock;

public class ReentrantLockDemo {
    private Object obj = new Object();

    public synchronized void synchronizedMethod1() {
        System.out.println("这是对象锁");
    }

    public void synchronizedMethod2() {
        synchronized (this){
            System.out.println("这是对象锁");
        }
    }

    public void synchronizedMethod3(){
        synchronized (obj){
            System.out.println("这是对象锁");
        }
    }
}

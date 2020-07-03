package com.algmachine.service.concurrency.volatilekeyword;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        TestVolatileThread thread = new TestVolatileThread();

        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);

        System.out.println("已经赋值为false");
    }
}

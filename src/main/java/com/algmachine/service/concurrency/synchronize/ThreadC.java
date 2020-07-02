package com.algmachine.service.concurrency.synchronize;

public class ThreadC extends Thread {
    private PublicVar publicVar;

    public ThreadC(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}

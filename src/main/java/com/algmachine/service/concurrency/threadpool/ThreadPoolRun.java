package com.algmachine.service.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolRun {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 10; i++) {
            Runnable work = new WorkThread("" + i);
            executor.execute(work);
        }

        executor.shutdown();
        System.out.println("Finished all threads");
    }

}

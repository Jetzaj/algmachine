package com.algmachine.service.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class Optimistic {
    private AtomicInteger value = new AtomicInteger();

    private void add() {
        value.incrementAndGet();
    }


}

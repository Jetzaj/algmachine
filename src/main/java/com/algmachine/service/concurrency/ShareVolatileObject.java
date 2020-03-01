package com.algmachine.service.concurrency;

import java.net.Socket;

public class ShareVolatileObject {
    private int years;
    private int months;
    public volatile int days;

    public void update(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }

    public int totalDays() {
        Socket socket = new Socket();
        int total = this.days;
        return total + years * 365 + months * 30;
    }
}

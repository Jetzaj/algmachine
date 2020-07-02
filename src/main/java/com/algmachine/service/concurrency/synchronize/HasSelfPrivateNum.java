package com.algmachine.service.concurrency.synchronize;

public class HasSelfPrivateNum {
    private int num = 0;

    public synchronized void addI(String userName) {
        try {
            if (userName.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                //如果去掉 thread.sleep(2000)，那么运行结果就会显示为同步的效果
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(userName + " num=" + num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

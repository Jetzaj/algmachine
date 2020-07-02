package com.algmachine.service.concurrency.synchronize;

public class Run {
//    public static void main(String[] args) {
//
//        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
//        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
//
//        ThreadA aThread = new ThreadA(numRef1);
//        aThread.start();
//
//        ThreadB bThread = new ThreadB(numRef1);
//        bThread.start();
//
//    }


    public static void main(String[] args) {
        try {
            PublicVar publicVarRef = new PublicVar();
            ThreadC thread = new ThreadC(publicVarRef);
            thread.start();
            Thread.sleep(200);//打印结果受此值大小影响

            publicVarRef.getValue();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

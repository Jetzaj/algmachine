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


//    public static void main(String[] args) {
//        try {
//            PublicVar publicVarRef = new PublicVar();
//            ThreadC thread = new ThreadC(publicVarRef);
//            thread.start();
//            Thread.sleep(200);//打印结果受此值大小影响
//
//            publicVarRef.getValue();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        Task task = new Task();

        ThreadD thread1 = new ThreadD(task);
        thread1.start();

        ThreadE thread2 = new ThreadE(task);
        thread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }

        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }

        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }
}

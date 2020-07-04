package com.algmachine.service.coll;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.offer(5);
        priorityQueue.offer(-1);
        priorityQueue.offer(3);
        priorityQueue.offer(7);

        //查看入队顺序
        System.out.println("队列输出：" + priorityQueue);

        //peek方法获取队头元素但是不删除元素
        System.out.println("peek()方法获取队头：" + priorityQueue.peek());

        //查看第一个元素即为最小元素
        System.out.println("第一个队列元素出队：" + priorityQueue.poll());
        System.out.println("第二个队列元素出队：" + priorityQueue.poll());
        System.out.println("第三个队列元素出队：" + priorityQueue.poll());
        System.out.println("第四个队列元素出队：" + priorityQueue.poll());
        System.out.println("null队列：" + priorityQueue.poll());

    }

}
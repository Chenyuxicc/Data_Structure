package com.chen.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue=new PriorityQueue<>();
        queue.add(1);
        int a=queue.poll();
        int b=queue.poll();
        System.out.println("a:"+a+"  b:"+b);
    }
}

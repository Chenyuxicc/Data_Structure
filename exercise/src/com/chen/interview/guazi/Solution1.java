package com.chen.interview.guazi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/26 on 15:46
 **/
public class Solution1 {
    private static final Object mylock = new Object();
    private static int flag = 0;
    static class MyThread extends Thread{
        private String name;
        public MyThread(String name){
            this.name = name;
        }
        @Override
        public void run(){
            synchronized (mylock){
                try {
                    if(flag == 0){
                        for (int i = 1; i <= 5 ; i++) {
                            System.out.println(name+ ":" +i);
                        }
                        flag = 1;
                        mylock.wait();
                    }else {
                        for (int i = 6; i <= 10 ; i++) {
                            System.out.println(name+ ":" +i);
                        }
                        mylock.notify();

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {

        Thread thread1 = new MyThread("thread-1");
        Thread thread2 = new MyThread("thread-2");

        try {
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
            System.out.println("success");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.chen.interview.guazi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/26 on 19:00
 **/
public class Solution2 {
    private static  Object LOCK = new Object();
    private static boolean flag = false;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (LOCK) {
                    flag = true;
                    if (atomicInteger.get() % 2 == 0) {
                        System.out.println("A");
                        atomicInteger.incrementAndGet();
                        LOCK.notify();
                    } else {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });
        Thread thread2 = new Thread(() -> {
            if (!flag) {
                synchronized (LOCK) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                while (true) {
                    synchronized (LOCK){
                        if (atomicInteger.get() % 2 == 1) {
                            System.out.println("B");
                            atomicInteger.incrementAndGet();
                            LOCK.notify();
                        } else {
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("success");
    }
}

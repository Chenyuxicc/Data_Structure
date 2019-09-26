package com.chen.interview.guazi;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/26 on 20:09
 **/
public class Solution3 {
    static final Object object = new Object();
    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(() -> {
           while (true){
               synchronized (object){
                   System.out.println("12345");
                   object.notify();

                   try {
                       object.wait();
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
           }
        });
        Thread thread2 = new Thread(() -> {
            while (true){
                synchronized (object){
                    System.out.println(":678910");
                    object.notify();

                    try {
                        object.wait();
                    }catch (Exception e){
                        e.printStackTrace();
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

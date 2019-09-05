package com.chen.test.mulThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:14
 */
class Task implements Runnable{
    String name;
    public Task(String name){
        this.name = name;
    }
    @Override
    public void run(){
        System.out.println("this is:"+name);
    }
}
class myThread extends Thread{
    String name;
    public myThread(String name){
        this.name = name;
    }
    @Override
    public void run(){
        System.out.println("this is:"+name);
    }
}
public class OrderThread {
    static ExecutorService service = Executors.newSingleThreadExecutor();
    public static void main(String[] args) {
        Task task1 = new Task("thread1");
        Task task2 = new Task("thread2");
        Task task3 = new Task("thread3");
        myThread thread1 = new myThread("1");
        myThread thread2 = new myThread("2");
        myThread thread3 = new myThread("3");
        //execute没有返回结果，但是submit有返回结果
        service.execute(task1);
        service.submit(task1);
        service.submit(task2);
        service.submit(task3);

        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        return;

    }
}
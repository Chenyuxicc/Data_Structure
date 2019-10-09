package com.chen.swordOffer2;

/**
 * @author chenyuxi
 * @since 19-10-9:上午10:26
 */

/**
 * 单例模式两个要求：1.延迟初始化 2.线程安全
 * 双重校验模式，几个需要注意的点
 * 1.实例和构造函数都是私有的,实例必须是static的，且需要使用volatile禁止指令重拍
 * 因为在多线程的情况下，双重校验模式可能会返回一个不正确的对象
 * 在new SingleTon1()时可能会先分配内存，获取到一个没有实例化的对象
 *
 * 2.使用双重校验锁的好处，一是延迟初始化，二是在加锁的外面再加一层判断，避免了加锁带来的线程阻塞
 */
class SingleTon1{
    private static volatile SingleTon1 singleTon1;
    private SingleTon1(){};
    public static SingleTon1 getSingleTon1(){
        if(singleTon1 == null){
            synchronized (SingleTon1.class){
                if(singleTon1 == null){
                    singleTon1 = new SingleTon1();
                }
            }
        }
        return singleTon1;
    }
}
/**
 * 静态内部类
 * 因为类的初始化过程是线程安全的，即使有两个线程同时调用getInstance方法，此时也只会引起一次内部类的初始化
 * static变量的初始化是在<clinit>()方法中执行的，而虚拟机会保证一个类的<clinit>()在多线程的环境下被正确的加锁、同步
 * 如果多个线程去初始化一类，那么只会有一个线程去执行这个类的<clinit>方法，其他线程需要阻塞
 * 延迟初始化保证：在调用getInstance()方法时，才会初始化内部类，并初始化static对象
 */
class SingleTon2{
    private static class InnerSingleTon{
        private  static SingleTon2 singleTon2 = new SingleTon2();
    }
    public static SingleTon2 getInstance(){
        return InnerSingleTon.singleTon2;
    }

}

public class S1_SingleTon {

}

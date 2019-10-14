package com.chen.swordOffer2;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/30 on 15:30
 **/
/**
 * 单例模式：全局范围内只存在一个该类的实例
 * 需要注意的点：
 * 1.实例对象为private static;
 * 2.具有一个私有的构造方法
 * 3.有一个共有的public static方法，用来获取该实例对象
 * 饿汉模式：不关是否需要都先创建这个实例
 */
class SingleTon1{
   private static SingleTon1 singleTon1 = new SingleTon1();
   private SingleTon1(){}
   public static SingleTon1 getSingleTon1(){
       return singleTon1;
   }
}
/**
 * 饿汉模式二：将对象创建放入静态块里
 */
class SingleTon2{
    private static SingleTon2 singleTon2 = null;
    static {
        singleTon2 = new SingleTon2();
    }
    private SingleTon2(){}
    public static SingleTon2 getSingleTon2(){
        return singleTon2;
    }
}
/**
 * 懒汉模式：需要时才创建该实例
 * 非线程安全
 */
class SingleTon3{
    private static SingleTon3 instance = null;
    private SingleTon3(){}
    public static SingleTon3 getInstance(){
        if(instance == null){
            instance = new SingleTon3();
        }
        return instance;
    }
}
/**
 * 懒汉模式：线程安全，加锁
 * 直接对方法进行加锁，每一个线程想调用该方法的时都先要获取锁，会造成其他线程阻塞
 * 降低性能
 */
 class SingleTon4{
    private volatile static SingleTon4 instance = null;
    private SingleTon4(){}
    public static synchronized SingleTon4 getInstance(){
        if(instance == null){
           instance = new SingleTon4();
        }
       return instance;
    }
}
/**
 * 懒汉模式：双重校验锁
 * 考虑不将锁直接加在方法当中，而是做双重校验，首先判断instance是否为空,
 * 如果不为空可以直接返回结果，大多数线程是都可以得到已经实例化的instance的
 * 在instance还没有实例化之前，如果两个线程同时都判断instance为null，都进了
 * if里面，此时才会去争抢锁，如果一个线程先拿到了锁，就将此对象实例化，另一个
 * 线程再此拿到锁的时候就会先判断是否为空，此时已经不为空就直接会返回对应的实例
 * 如果不加第一次判断那每一次都会需要获取锁，如果不加第二次判断，那会创建不同的对象
 */
class SingleTon5{
    private static SingleTon5 instance = null;
    private SingleTon5(){}
    public static SingleTon5 getInstance(){
        if(instance == null){
            synchronized (SingleTon5.class){
                if(instance == null){
                    instance = new SingleTon5();
                }
            }
        }
        return instance;
    }
}
/**
 * 指令重排的问题：
 * 创建对象的三步：1.分配内存 2.初始化 3.将内存地址赋值给引用
 * 如果第2步和第3步发生顺序改变，就会将没有初始化的内存地址赋值给引用
 * 如果此时又有一个线程去获取这个实例，先判断这个实例不为空，就直接返回了
 * 这个线程是不需要获取锁的
 *
 */
class SingleTon6{
    private static volatile SingleTon6 singleTon6 = null;
    private SingleTon6(){}
    public static SingleTon6 getSingleTon6(){
        if(singleTon6 == null){
            synchronized (singleTon6){
                if(singleTon6 == null){
                    singleTon6 = new SingleTon6();
                }
            }
        }
        //如果不加volatile关键字，在第二个线程调用该方法时，首先判断singleTon6不为空
        //此时会直接返回一个还没有初始化完成的对象，会出问题，加上volatile关键字禁止指令重排
        return singleTon6;
    }
}
/**
 * 静态内部类
 *
 */
public class S1_SingleTon {
    private S1_SingleTon(){}
    private static class SingleTon{
        //在静态类的内部创建一个外部类的对象
        private static S1_SingleTon instance = new S1_SingleTon();
    }
    public static S1_SingleTon getInstance(){
        return SingleTon.instance;
    }
}

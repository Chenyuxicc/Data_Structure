package com.chen.test;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/2 on 19:06
 **/
class HelloA{
    public HelloA(){
        System.out.println("HelloA");
    }
    {
        System.out.println("I'm A class");
    }
    static {
        System.out.println("static A");
    }
}
public class HelloB extends HelloA{
    public HelloB(){
        System.out.println("HelloB");
    }
    {
        System.out.println("I'm B class");
    }
    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}

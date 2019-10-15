package com.chen.test;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/27 on 15:26
 **/
public class gcbTest {
    public static int gcb(int a,int b){
        int c=0;
        while(b!=0){
            c=b;
            b=a%b;
            a=c;
        }
        return a;
    }

    public static void main(String[] args) {
        int c=gcb(7,2);
        System.out.println("c:"+c);
    }
}

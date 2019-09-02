package com.chen.interview.douyu;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/1 on 12:05
 **/
public class StringTest {
    public static void main(String[] args) {
        String s1 = "bad";
        String s2 = "good";
        exchange(s1,s2);
        System.out.println(s1);
        System.out.println(s2);
        StringBuilder s3 = new StringBuilder("bad");
        StringBuilder s4 = new StringBuilder("good");
        exchange(s3,s4);
        System.out.println(s3);
        System.out.println(s4);
    }
    public static void exchange(String s1,String s2){
        s1 = s2;
        s2 = new String();
        s1 += " world!";
        s2 += " world!";
    }
    public static void exchange(StringBuilder s1,StringBuilder s2){
        s1 = s2;
        s2 = new StringBuilder();
        s1.append(" world!");
        s2.append(" world!");
    }
}

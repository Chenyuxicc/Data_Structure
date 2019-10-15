package com.chen.test;

public class FinallyTest {
    public static void main(String[] args) {
        int value=7;
        try{
            value++;
            return;
        }finally {
            System.out.println("value:"+value);
        }
    }
}

package com.chen.test;

import java.util.Date;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/10 on 14:22
 **/
public class TestData {

    private int count = 0;

    public static void main(String[] args) {
        TestData testData = new TestData();
        testData.test1();
    }

    public void test1(){
        Date date = new Date();
        String name1 = "wangerbei";
        test2(date,name1);
        System.out.println(date+name1);
    }

    public void test2(Date dateP,String name2){
        dateP = null;
        name2 = "zhangsan";
    }

    public void test3(){
        count++;
    }

    public void  test4(){
        int a = 0;
        {
            int b = 0;
            b = a+1;
        }
        int c = a+1;
    }
}

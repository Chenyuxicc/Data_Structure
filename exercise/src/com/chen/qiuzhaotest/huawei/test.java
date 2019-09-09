package com.chen.qiuzhaotest.huawei;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/7 on 21:17
 **/
public class test {
    public static void main(String[] args) {
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i <10000 ; i++) {
            result1 += i;
        }
        System.out.println(result1%7);

        for (int i = 0; i <10000 ; i++) {
            result2 += i;
            result2 %= 7;
        }
        System.out.println(result2);
    }
}

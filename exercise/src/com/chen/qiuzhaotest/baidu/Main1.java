package com.chen.qiuzhaotest.baidu;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/17 on 19:40
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int a = 0;
        int b = 0;
        while ((n - a) * (m - b) > k){
            if(n > m){
                b++;
            }else{
                a++;
            }
        }
        int sum = a + b;
        System.out.println(sum);
    }
}

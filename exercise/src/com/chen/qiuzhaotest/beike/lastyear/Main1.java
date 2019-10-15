package com.chen.qiuzhaotest.beike.lastyear;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/10 on 15:29
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.valueOf(in.nextLine());
        String[] s = in.nextLine().trim().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        int numOfMethod = 0;
        for (int i = 1; i < s.length ; i++) {
            int sum1 = 0 ;
            int sum2 = 0 ;
            for (int j = 0; j < i ; j++) {
                sum1 += arr[j];
            }
            for (int j = i; j < s.length ; j++) {
                sum2 += arr[j];
            }
            if(sum1 == sum2 ){
                numOfMethod++;
            }
        }
        System.out.println(numOfMethod);
        return;
    }
}

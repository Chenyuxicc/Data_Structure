package com.chen.qiuzhaotest.huawei;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/7 on 19:10
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().trim().split(" ");
        int length = s.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        if(length == 2){
            System.out.println(1);
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < length/2; i++) {
            int j = i;
            int count = 1;
            while (j < length-1){
                j = arr[j] + j;
                count++;
            }
            if(j == length - 1){
                if(count < min){
                    min = count;
                }
            }
        }
        if(min != Integer.MAX_VALUE){
            System.out.println(min);
        }else {
            System.out.println(-1);
        }
    }
}

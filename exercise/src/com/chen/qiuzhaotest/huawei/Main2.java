package com.chen.qiuzhaotest.huawei;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/7 on 19:27
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().trim().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        long[] arr = new long[n];
        if(m == 1){
            System.out.print(n);
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        int count = m;
        long result = 0;
        while (count > 1){
            for (int i = 0; i < n; i++) {
                int num = 0;
                for (int j = i; j < n; j++) {
                    num += arr[j];
                    arr[i] %= 1000000007;
                }
                arr[i] = num;
            }
            count--;
        }

        for (int i = 0; i < n; i++) {
            result += arr[i];
            result %= 1000000007;
        }
        System.out.print(result);
    }
}

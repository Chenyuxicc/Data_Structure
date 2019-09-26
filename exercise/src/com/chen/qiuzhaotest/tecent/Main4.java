package com.chen.qiuzhaotest.tecent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/20 on 20:54
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(num);
        int[] result = new int[k];
        int first = -1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if(num[j] != 0){
                    first = num[j];
                    result[i] = first;
                    break;
                }
            }
            if(first == -1){
                result[i] = 0;
                continue;
            }
            for (int j = 0; j < n; j++) {
                if(num[j] != 0){
                    num[j] -= first;
                }
            }
        }
        for (int i = 0; i < k ; i++) {
            System.out.println(result[i]);
        }
    }
}

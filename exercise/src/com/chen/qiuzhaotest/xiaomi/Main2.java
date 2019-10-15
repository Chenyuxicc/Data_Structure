package com.chen.qiuzhaotest.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/6 on 20:00
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.valueOf(in.nextLine());
        double[] values = new double[count];
        int numOfProduct = 0;
        for (int i = 0; i < count; i++) {
            values[i] = Integer.valueOf(in.nextLine());
        }
        double money = Double.valueOf(in.nextLine());
        Arrays.sort(values);
        for (int i = count - 1; i >= 0 ; i--) {
            while (money >= values[i]){
                money -= values[i];
                numOfProduct++;
            }
        }
        if(money <= 0.0000001 && money >= -0.0000001){
            System.out.println(numOfProduct);
        }else {
            System.out.println(-1);
        }
    }
}

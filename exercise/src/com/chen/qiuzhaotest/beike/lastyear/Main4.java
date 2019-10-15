package com.chen.qiuzhaotest.beike.lastyear;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/10 on 16:04
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testNum  = Integer.valueOf(in.nextLine());
        int[] test = new int[testNum];
        int[] result = new int[testNum];
        for (int i = 0; i < testNum ; i++) {
            test[i] = Integer.valueOf(in.nextLine());
        }
        for (int i = 0; i < testNum; i++) {
            int temp = test[i];
            int resultnum = 0;
            while (temp > 0){
                while (temp >= 100){
                    resultnum ++;
                    temp -= 100;
                }
                while (temp >= 50){
                    resultnum ++;
                    temp -= 50;
                }
                while (temp >= 20){
                    resultnum ++;
                    temp -= 20;
                }
                while (temp >= 10){
                    resultnum ++;
                    temp -= 10;
                }
                while (temp >= 5){
                    resultnum ++;
                    temp -= 5;
                }
                while (temp >= 2){
                    resultnum ++;
                    temp -= 2;
                }
                while (temp >= 1){
                    resultnum ++;
                    temp -= 1;
                }

            }
            result[i] = resultnum;
        }
        for (int i = 0; i < testNum ; i++) {
            System.out.println(result[i]);
        }
        return;
    }
}

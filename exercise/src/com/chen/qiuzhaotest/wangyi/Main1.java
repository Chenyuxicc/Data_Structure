package com.chen.qiuzhaotest.wangyi;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/3 on 15:25
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int classMatesNum = Integer.valueOf(in.nextLine());
        String[] s = in.nextLine().trim().split(" ");
        int[] arrGrade = new int[classMatesNum];
        for (int i = 0; i <classMatesNum ; i++) {
            arrGrade[i] = Integer.valueOf(s[i]);
        }
        int askMatesNum = Integer.valueOf(in.nextLine());
        int[] arrMate = new int[askMatesNum];
        int i = 0;
        while (i<askMatesNum){
            arrMate[i] = Integer.valueOf(in.nextLine());
            i++;
        }
        double[] gradePercentage = new double[askMatesNum];
        for (int j = 0; j < askMatesNum ; j++) {
            int grade = arrGrade[arrMate[j]-1];
            int num = 0;
            for (int k = 0; k <classMatesNum ; k++) {
                if(arrGrade[k] <= grade){
                    num++;
                }
            }
            gradePercentage[j] = 100*(num - 1)/(classMatesNum*1.0);
        }
        DecimalFormat df = new DecimalFormat("0.000000");

        for (int j = 0; j <askMatesNum ; j++) {
            System.out.println(df.format(gradePercentage[j]));
        }
    }
}

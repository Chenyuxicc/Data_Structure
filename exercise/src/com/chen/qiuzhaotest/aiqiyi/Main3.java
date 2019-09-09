package com.chen.qiuzhaotest.aiqiyi;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/8 on 16:49
 **/
public class Main3 {
    int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.valueOf(in.nextLine());
        int[] P = new int[num];
        int[] A = new int[num - 1];
        for (int i = 0; i < num - 1; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < num ; i++) {
            P[i] = 1 + i;
        }
    }
    private static int correct(){

    }


}

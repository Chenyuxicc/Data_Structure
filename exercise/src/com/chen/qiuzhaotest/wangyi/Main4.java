package com.chen.qiuzhaotest.wangyi;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/3 on 16:22
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().trim().split(" ");
        int num1 = Integer.valueOf(s[0]);
        int num2 = Integer.valueOf(s[1]);
        String[] s1 = in.nextLine().trim().split(" ");
        int[] arr1 = new int[num1];
        int[] arr2 = new int[num2];
        for (int i = 0; i <num1 ; i++) {
            arr1[i] = Integer.valueOf(s1[i]);
        }
        int i = 0;
        while (i<num2){
            arr2[i] = Integer.valueOf(in.nextLine());
            i++;
        }
        int[] nums = new int[num2];
        for (int j = 0; j < num2 ; j++) {
            int temp = arr2[j];
            int num = 0;
            for (int k = 0; k < num1 ; k++) {
                if(arr1[k] >= temp ){
                    arr1[k] = arr1[k] - 1;
                    num++;
                }
            }
            nums[j] = num;
        }
        for (int j = 0; j < num2 ; j++) {
            System.out.println(nums[j]);
        }
    }
}

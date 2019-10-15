package com.chen.qiuzhaotest.tecent;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/20 on 20:04
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.valueOf(in.nextLine());
        int[] lengthOfNum = new int[count];
        String[] nums = new String[count];
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            lengthOfNum[i] = Integer.valueOf(in.nextLine());
            nums[i] = in.nextLine();
        }
        for (int i = 0; i < count; i++) {
            result[i] = "NO";
        }
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < nums[i].length(); j++) {
                if(nums[i].charAt(j) == '8'){
                    result[i] = nums[i].length() - j >= 11 ? "YES" : "NO";
                    break;
                }
                break;
            }

        }
        for (int i = 0; i < count ; i++) {
            System.out.println(result[i]);
        }
    }
}

package com.chen.qiuzhaotest.pingduoduo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/1 on 15:10
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(",|;");
        Integer[] nums = new Integer[arr.length-1];
        int count = Integer.valueOf(arr[arr.length-1]);
        for (int i = 0; i < arr.length-1; i++) {
            nums[i] = Integer.valueOf(arr[i]);
        }
        Arrays.sort(nums);
        ArrayList<Integer> arrayList = new ArrayList<>(count);
        int t = count;
        int i = nums.length-1;
        int j = 0;
        int[] result = new int[count];
        while (i > 0 && t > 0){
            if(nums[i] % 2 == 0){
                result[j] = nums[i];
                j++;
                t--;
            }
            i--;
        }
        i = nums.length-1;
        while (i > 0 && t > 0){
            if(nums[i] % 2 == 1){
                result[j] = nums[i];
                j++;
                t--;
            }
            i--;
        }
        for (int k = 0; k < result.length; k++) {
            if(k == result.length-1){
                System.out.print(result[k]);
            }else {
                System.out.print(result[k]+",");
            }
        }
    }
}

package com.chen.qiuzhaotest.yuanfudao;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/16 on 10:06
 **/
public class Main2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String[] s = in.nextLine().split(" ");
//        int count = Integer.valueOf(s[0]);
//        int num = Integer.valueOf(s[1]);
//        String[] s1 = in.nextLine().split(" ");
//        int[] arr = new int[s1.length];
//        for (int i = 0; i < s1.length; i++) {
//            arr[i] = Integer.valueOf(s1[i]);
//        }
        int[] arr = {3,1,1,3};
        int num = 8;
        System.out.println(findLongSub(arr,num));
    }
    private static int findLongSub(int[] arr,int num){
        int indexI = 0;
        int indexJ = 0;
        int sum = 0;
        int curWindow = indexJ - indexI;
        int maxWindow = curWindow;
        while (indexI < arr.length && indexJ < arr.length){
            sum += arr[indexJ];
            if(sum == num){
                curWindow = indexJ - indexI + 1;
                if(curWindow > maxWindow){
                    maxWindow = curWindow;
                }
                indexI++;
                indexJ++;
                sum -= arr[indexI - 1];
            }else if(sum < num){
                curWindow = indexJ - indexI + 1;
                if(curWindow > maxWindow){
                    maxWindow = curWindow;
                }
                indexJ ++ ;
            }else {
                sum -= arr[indexI];
                sum -= arr[indexJ];
                indexI++ ;
                curWindow--;
            }
        }
        return maxWindow;
    }
}

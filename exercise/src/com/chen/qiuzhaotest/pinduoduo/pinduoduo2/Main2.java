package com.chen.qiuzhaotest.pinduoduo.pinduoduo2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/11 on 15:46
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

    }
    public int minNum(int[] arr,int l,int start,int end){
        if(end-start == 0){
            return 0;
        }
        if(end - start == 1){
            int min = 0;
            if(arr[end] - arr[start] < l-(arr[end]-arr[start])-1){
                min = arr[end] - arr[start] - 1;
                arr[end] = arr[start]+1;
            }else {
                min = l-(arr[end] - arr[start]) - 1;
                arr[end] = arr[start]-1;
                if(arr[start] - 1 < 0){
                    arr[end] = l-1;
                }
            }
            return min;
        }
        int minNum = Integer.MAX_VALUE;
        for (int i = start; i < end ; i++) {
            int min1 = minNum(arr,l,start,i);
            int min2 = minNum(arr,l,i+1,end);
            int temp1 = (arr[i+1] - arr[i] - 1) * (end - i);
            int temp2 = 0;
            for (int j = 0; j < end-i ; j++) {
                temp2 = arr[i+1+j];
            }
        }
        return 0;
    }
}

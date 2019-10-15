package com.chen.interview;

import java.util.Arrays;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/22 on 10:33
 **/
public class Kuaipai {
    public static void main(String[] args) {
        int[] arr = {3,1,5,9,2,0};
        int left = 0;
        int right = arr.length-1;
        QuickSort(arr,left,right);
        System.out.println(Arrays.toString(arr));
    }
    public static void QuickSort(int[] arr,int left,int right){
        if(left < right){
            int partition = partition(arr,left,right);
            QuickSort(arr,left,partition-1);
            QuickSort(arr,partition+1,right);
        }
    }
    public static int partition(int[] arr,int left,int right){
        int temp = arr[0];
        while (left < right){
            while (arr[right] > temp){
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] < temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}

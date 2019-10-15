package com.chen.qiuzhaotest.tecent;


import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/20 on 20:24
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[100000000];
        int j = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            for (int k = 0; k < x ; k++) {
                array[j++] = y;
            }
            buildheapy(array,j);

        }
        int sum = 0;
        for (int i = 0; i < j/2; i++) {
            sum = Math.max(array[i] + array[j - i - 1] , sum);
        }
        System.out.println(sum);
    }

    private static void buildheapy(int[] arr,int n){
        int c = (n - 2) / 2;
        for (int i = c; i >= 0; i--) {
            heapfy(arr,n,i);
        }
    }
    private static void heapfy(int[] arr , int n,int i){
        if(i >= n) {
            return;
        }
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;

        int max = i;
        if(c1 < n && arr[c1] > arr[max]){
            max = c1;
        }
        if(c2 < n && arr[c2] > arr[max]){
            max = c2;
        }
        if(max != i){
            swap(arr,max,i);
            heapfy(arr,n,max);
        }
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

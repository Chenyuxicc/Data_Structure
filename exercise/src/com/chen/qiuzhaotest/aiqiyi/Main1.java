package com.chen.qiuzhaotest.aiqiyi;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/8 on 14:56
 **/
public class Main1 {
    public static int count=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int P[] = new int[n];
        int A[] = new int[n-1];
        for(int i=0;i<n-1;i++){
            A[i] = in.nextInt();
        }
        for(int i=0;i<n;i++) {
            P[i] = i+1;
        }
        correct(P,0,A);
        System.out.println(count);
    }

    private static void correct(int[] arr, int start, int[] a) {
        if(start==arr.length-1) {
            if(isIllegal(arr,a)) {
                count++;
                count=count%1000000007;
            }
        }
        for(int i=start;i<arr.length;i++) {
            swap(arr,i,start);
            correct(arr, start+1,a);
            swap(arr, i, start);
        }
    }

    private static boolean isIllegal(int[] P, int[] A) {
        for(int i=0;i<A.length;i++) {
            if(A[i]==0) {
                if(P[i]>P[i+1]) {
                    return false;
                }
            }else {
                if(P[i]<P[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void swap(int[] P, int i, int start) {
        int temp = P[i];
        P[i] = P[start];
        P[start] = temp;
    }
}

package com.chen.qiuzhaotest.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/27 on 20:00
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String strings = scanner.nextLine();
        String[] s = strings.trim().split(" ");
        String[] s1 = new String[n-1];
        int[] arr = new int[n];
        int j = 0;
        int k = 0;
        for (int i = 0; i < s.length ; i++) {
            if(i % 2 == 0){
                arr[j] = Integer.valueOf(s[i]);
                j++;
            }else {
                s1[k] = s[i];
                k++;
            }
        }
        int i = 0;
        int low = 0;
        int high = 0;
        while (i < s1.length){
            low = i;
            while ("+".equals(s1[i]) || "-".equals(s1[i])){
                i++;
            }
            high = i;
            sort(arr,low,high);
            int m = i;
            while ("*".equals(s1[i]) || "/".equals(s1[i])){
                i++;
            }
            sort(arr,m,i-1);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] num,int left,int right){
        if(left < right && right > 0){
            int p = partition(num,left,right);
            sort(num,left,p-1);
            sort(num,p+1,right);
        }
    }
    public static int partition(int[] num,int left,int right){
        int temp = num[left];
        while (left < right){
            while (num[right] > temp){
                right--;
            }
            num[left] = num[right];
            while (num[left] < temp){
                left++;
            }
            num[right] = num[left];
        }
        num[left] = temp;
        return left;
    }
}

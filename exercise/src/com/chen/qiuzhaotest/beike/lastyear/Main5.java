package com.chen.qiuzhaotest.beike.lastyear;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/10 on 16:17
 **/
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfChildren = Integer.valueOf(in.nextLine());
        DecimalFormat df = new DecimalFormat("0.0000");
        int[] arr = new int[numOfChildren];
        for (int i = 0; i < numOfChildren ; i++) {
            arr[i] = i+1;
        }
        int num = 0;
        String sorigin = String.valueOf(arr);
        HashSet<String> set = new HashSet<>();
        fullsort(set,arr,0);
        for (String s: set) {
            char[] chars = s.toCharArray();
            char[] chars1 = sorigin.toCharArray();
            for (int i = 0; i < s.length() ; i++) {
                if(chars[i] == chars1[i]){
                    num++;
                    break;
                }
            }
        }
        String t = df.format(num/(set.size()*1.0));
        System.out.println(t);
    }
    public static void fullsort(HashSet<String> res,int[] arr,int i){
        if(i == arr.length-1){
            res.add(String.valueOf(arr));
            return;
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr,i,j);
            fullsort(res,arr,i+1);
            swap(arr,i,j);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

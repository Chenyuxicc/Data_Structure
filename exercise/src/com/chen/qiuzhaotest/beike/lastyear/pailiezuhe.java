package com.chen.qiuzhaotest.beike.lastyear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/10 on 16:49
 **/
public class pailiezuhe {
    public static void main(String[] args) {
        char[] arr = {'a','b','c','d'};
        HashSet<String> set = new HashSet<>();
        fullSort(set,arr,0,arr.length-1);
        System.out.println(Arrays.toString(set.toArray()));

    }
    public static void fullSort(HashSet<String> res,char[] arr, int start, int end){
        if(start == arr.length-1){
            res.add(String.valueOf(arr));
            return;
        }
        for (int i = start; i <= end ; i++) {
            swap(arr,i,start);
            fullSort(res,arr,start+1,end);
            swap(arr,i,start);
        }
    }
    private static void swap(char[] arr,int i,int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

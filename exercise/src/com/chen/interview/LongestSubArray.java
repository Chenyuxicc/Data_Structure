package com.chen.interview;

import java.util.*;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/24 on 9:02
 **/
public class LongestSubArray {
    public static void main(String[] args) {
        int[] num = {8,5,1,6,8,2,4,5,10};
        ArrayList<Integer> arr = new ArrayList<>();
        test(arr,num);
    }
    public static void test(ArrayList<Integer> arr,int[] num){
        for (int t:num) {
            if(arr.size() == 0 || arr.get(arr.size() - 1) < t){
                arr.add(t);
            }else {
                int i = Collections.binarySearch(arr,t);
                arr.set(i < 0 ? - i - 1 : i,t);
            }
        }
    }
}


package com.chen.leetcode.arrrayMath;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:15
 */
public class LongestSubArray {
    public int findLengthOfLCIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : nums){
            if(arr.size() == 0 || arr.get(arr.size() - 1) < num){
                arr.add(num);
            }else{
                int i = Collections.binarySearch(arr,num);
                arr.set(i < 0 ? - i - 1 : i , num);
            }
        }
        return arr.size();
    }
}

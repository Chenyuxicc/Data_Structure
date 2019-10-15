package com.chen.leetcode.subSequence;

/**
 * @author chenyuxi
 * @since 19-9-5:下午7:09
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 最长连续递增子序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 滑动窗口的思想，当滑动到一个位置，该位置上的值小于等于其前一个位置的值时，改变滑动窗口的起始位置
 * 使用max记录滑动窗口的大小
 * 这题是要求连续而且递增，找到不是递增的那个就开始重头计算窗口的大小
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums){
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] > nums[i-1]){
                max = Math.max(max,++count);
            }else {
                count = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        int t = Collections.binarySearch(arr,4);
        arr.set(-t-1,4);
    }
}

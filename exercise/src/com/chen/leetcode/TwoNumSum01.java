package com.chen.leetcode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/14 on 20:52
 **/
public class TwoNumSum01 {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int[] result = new int[2];
        while (start < end){
            if(nums[start] + nums[end] < target){
                start ++;
            }else if(nums[start] + nums[end] > target){
                end --;
            }else {
                result[0] = start;
                result[1] = end;
                break;
            }
        }
        return result;
    }
}

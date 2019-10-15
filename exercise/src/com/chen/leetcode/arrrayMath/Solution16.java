package com.chen.leetcode.arrrayMath;

import java.util.Arrays;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/30 on 16:56
 **/
public class Solution16 {
    //不用考虑去重
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-1; i++) {
            int l = i+1;
            int r = nums.length-1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(result-target) > Math.abs(sum - target)){
                    result = sum;
                }
                if(sum > target){
                    r--;
                }else if(sum < target){
                    l++;
                }else {
                    return target;
                }
            }
        }
        return result;
    }
}

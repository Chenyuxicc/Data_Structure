package com.chen.leetcode.dp;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:06
 */
public class Solution53 {
    /**
     * 1.状态方程：sum(i) = sum(i-1) > 0 ? sum(i-1) + nums[i] : num[i]
     * 2.使用一个max记录最大的sum
     *
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = nums[0];
        int sum = 0;
        for (int n : nums) {
            if(sum > 0){
                sum += n;
            }else {
                sum = n;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
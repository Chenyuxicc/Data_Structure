package com.chen.leetcode.hashmap;

import java.util.HashSet;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:08
 */
public class Solution128 {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int max = 1;
        for (int i = 0; i < nums.length ; i++) {
            set.add(nums[i]);
        }
        for (Integer num : nums) {
            int temp = num;
            int cur = 1;
            if(set.remove(num)){
                //这里使用num-1而不用num--就可以避免num--不存在，但是num的值却减少了1个，避免了判断
                while (set.remove(num-1)){
                    num--;
                }
                cur += temp - num;
                num = temp;
                while (set.remove(num+1)){
                    num++;
                }
                cur += num - temp;
                max = Math.max(cur,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}

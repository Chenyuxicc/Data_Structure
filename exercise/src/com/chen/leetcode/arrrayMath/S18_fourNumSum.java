package com.chen.leetcode.arrrayMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/30 on 11:01
 * 题：在数组中找出四个和为target的元素，找出所有满足条件且不重复的四元组
 **/
public class S18_fourNumSum {
    /**
     * 思路：使用一个指针遍历，循环体内当三数之和来做
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            //去重
            if(i > 0 && nums[i] == nums[i - 1]){continue;}
            for (int j = i + 1; j < length - 2; j++) {
                //去重
                if(j > i + 1 && nums[j] == nums[j - 1]){continue;}
                int k = j + 1;
                int m = length - 1;
                while (k < m){
                    //去重，注意k++
                    if(k > j +1 && nums[k] == nums[k-1]){k++;continue;}
                    //去重，注意m--
                    if(m < length - 1 && nums[m] == nums[m+1]){m--;continue;}
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if(sum > target){
                        m--;
                    }else if(sum < target){
                        k++;
                    }else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[m]));
                        k++;
                        m--;
                    }
                }
            }
        }
        return result;
    }
}

package com.chen.leetcode.arrrayMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/30 on 15:52
 **/
public class Solution15 {
    /**
     * 递增数组中求和为0的三个数
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arrayLists = new ArrayList<>();
        int sum = -1;
        for (int i = 0; i < nums.length-1 ; i++) {
            //此时不可能为0
            if(nums[i] > 0){break;}
            //去重，num[i]和后面的是不一样的，如果nums[i-1]等于nums[i],此时可能会有重复，需要去掉
            if(i > 0 && nums[i] == nums[i-1]){ continue; }
            int j = i+1;
            int k = nums.length-1;
            while (j < k){
                sum = nums[j] + nums[k] + nums[i];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else {
                    arrayLists.add(Arrays.asList(nums[i],nums[k],nums[j]));
                    //之后的两个数都要考虑去重
                    while (j < k && nums[j] == nums[j+1]){ j++; }
                    while (j < k && nums[k] == nums[k-1]){ k--; }
                    j++;
                    k--;
                }
            }
        }
        return arrayLists;
    }
}

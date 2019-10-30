package com.chen.leetcode.arrrayMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/30 on 15:52
 * 题：递增数组中求和为0的三个数
 **/
public class S15_threeNumSum {
    /**
     * 思路：排序，指针i用来遍历，考察j以及k的值相加是否满足条件
     * 移动i和j和k的条件:
     * 1.num[i] > target 直接跳出 num[i] == num[i-1]此时会出现重复，直接继续循环
     * 2.j = i + 1 k = length - 1 再遍历所有的j和k的值，基础思路：小于target j++ 大于target k--
     * 3.当已经找到值时直接放入List当中，考虑去重，如果相同则直接移动，直到不同；并移动j和k，。
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

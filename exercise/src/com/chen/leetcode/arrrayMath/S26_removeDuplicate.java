package com.chen.leetcode.arrrayMath;

import java.util.Arrays;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/1 on 10:51
 **/
public class S26_removeDuplicate {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (i > 0 && nums[i] == nums[i-1] && i < length){
                for (int j = i; j < length ; j++) {
                    nums[j-1] = nums[j];
                }
                length--;
            }
        }
        return length;
    }
    //双指针法，考虑到是排序的
    public static int removeDuplicates1(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}

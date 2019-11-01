package com.chen.leetcode.arrrayMath;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/1 on 11:47
 **/
public class S27_removeElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}

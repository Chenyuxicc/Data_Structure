package com.chen.leetcode.arrrayMath;

import java.util.HashSet;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/28 on 20:52
 **/
public class S217_duplicateNum {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            if(!set.contains(nums[j])){
                set.add(nums[j]);
            }else {
                return true;
            }
        }
        return false;
    }
}

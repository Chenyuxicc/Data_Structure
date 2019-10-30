package com.chen.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/28 on 21:01
 **/
public class S219_duplicateNum2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                ArrayList<Integer> temp = map.get(nums[i]);
                for (Integer t : temp) {
                    if(Math.abs(i - t) < k || Math.abs(i - t) == k){
                        return true;
                    }
                }
                temp.add(i);
                map.put(nums[i],temp);
            }else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                map.put(nums[i],arr);
            }
        }
        return false;
    }
    public boolean containsNearbyDuplicate1(int[] nums, int k){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
            if(set.size() == k + 1){
                set.remove(nums[i - k - 1]);
            }
            if(set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}

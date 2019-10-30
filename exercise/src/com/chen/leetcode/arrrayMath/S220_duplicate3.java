package com.chen.leetcode.arrrayMath;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/28 on 21:23
 * 题：判断一个数组中是否存在下标i和j相差小于等t而且值nums[i]和nums[j]相差小于等于k的这两个数
 **/
public class S220_duplicate3 {
    /**
     * 第一种想法，延续重复2中的滑动窗口思想，定下下标i和j的距离为k，再判断这些数的差值有没有小于等于t
     * 的有就直接返回true
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int i = 0;
        int j = i + k;
        if(nums.length == 0 || nums.length == 1){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        if(j >= nums.length){
            j = nums.length - 1;
            while (i <= j){
                int temp = t;
                while (temp >= 0){
                    if(set.contains(nums[i] -temp) || set.contains(nums[i] + temp)){
                        return true;
                    }
                    temp--;
                }
                set.add(nums[i]);
                i++;
            }
        }else{
            while (j < nums.length){
                int m = i;
                if(m == 0){
                    while (m <= j){
                        int temp = t;
                        while (temp >= 0){
                            if(set.contains(nums[m] - temp) || set.contains(nums[m] + temp)){
                                return true;
                            }
                            temp--;
                        }
                        set.add(nums[m]);
                        m++;
                    }
                }else {
                    int temp = t;
                    while (temp >= 0){
                        if(set.contains(nums[j] - temp) || set.contains(nums[j] + temp)){
                            return true;
                        }
                        temp--;
                    }
                    set.add(nums[j]);
                }
                set.remove(nums[i]);
                i++;
                j++;

            }
        }

        return false;
    }
    /**
     * 优解：使用TreeSet数据结构，TreeSet特点：有序，存入TreeSet中的元素必须重写compareTo()方法
     * ceiling(i)会返回set中大于或等于i的最小元素
     * flooring(i)返回set中小于或等于i的最大元素
     * 判断这两个元素的值和nums[i]的差值是否小于t，如果小于，直接返回true
     * 将元素nums[i]放入set中，同时判断set的大小以控制滑动窗口大小
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer s = set.ceiling(nums[i]);
            if(s != null && s <= nums[i] + t){
                return true;
            }
            Integer m = set.floor(nums[i]);
            if(m != null && m + t >= nums[i]){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10,100,11,9};
        int k = 1;
        int t = 2;
        S220_duplicate3 s = new S220_duplicate3();
        System.out.println(s.containsNearbyAlmostDuplicate(arr,k,t));
    }
}

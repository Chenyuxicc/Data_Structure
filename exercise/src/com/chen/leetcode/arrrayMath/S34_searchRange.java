package com.chen.leetcode.arrrayMath;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/14 on 19:43
 * 题目：在排序数组中查找元素的第一个和最后一个位置
 **/
public class S34_searchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(nums.length == 0){
            return result;
        }else if(nums.length == 1 && nums[0] != target){
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        if(left == nums.length){
            result[0] = -1;
        }else {
            result[0] = nums[left] == target ? left: -1;
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right){
            int mid = ( left + right )/2;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        if(left == 0){
            result[1] = -1;
        }else {
            result[1] = nums[left - 1] == target ? (left - 1) : -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        int[] result = searchRange(nums,3);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

package com.chen.leetcode.arrrayMath;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/19 on 21:46
 **/
public class S35_searchInsert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                break;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        if(nums[mid] == target){
            return mid;
        }else {
            return left;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,7));
    }
}

package com.chen.leetcode.arrrayMath;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/13 on 21:29
 * 题目：搜索旋转排序数组
 * 思路：先找到旋转点，再两边同时二分，找旋转点的二分和普通二分有细微差别，需要注意
 **/
public class S33_rotateArray {
    int result = -1;
    public  int minNum(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (nums[left] >= nums[right]){
            mid = (left+right)/2;
            if(left+1 == right){
                break;
            }
            if(nums[mid] > nums[left]){
                //因为是旋转数组，所以mid之前或者之后可能会和现在的状态不一致
                //并不能left = mid+1这种
                left = mid;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }
        }
        return left + 1;
    }
    public  int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int rotate = minNum(nums);
        int left = 0;
        int right = nums.length - 1;
        if(rotate > 0 && target >= nums[left] && target <= nums[rotate - 1]){
            right = rotate - 1;
            result = twoSearch(left,right,nums,target);
        }else if(target <= nums[right] && target >= nums[rotate]){
            left = rotate;
            result = twoSearch(left,right,nums,target);
        }else if(rotate == 0){
            result = twoSearch(left,right,nums,target);
        }
        return result;
    }
    public int twoSearch(int left,int right,int[] nums ,int target){
        int mid = 0;
        while (left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                break;
            }
            if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid + 1;
            }
        }
        if(nums[mid] != target){
            return -1;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        S33_rotateArray s33_rotateArray = new S33_rotateArray();
        System.out.println(s33_rotateArray.search(nums,3));
    }
}

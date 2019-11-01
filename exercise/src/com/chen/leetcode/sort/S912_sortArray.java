package com.chen.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/1 on 20:13
 **/
public class S912_sortArray {
    List<Integer> result = new ArrayList<>();
    public List<Integer> sortArray(int[] nums) {
        divideList(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            result.add(nums[i]);
        }
        return result;
    }
    /**
     * 递归拆分和递归合并，一直拆分到只剩一个元素
     */
    public void divideList(int[] nums , int start , int end){
        if(start < end){
            int mid = (start + end) / 2;
            divideList(nums,start,mid);
            divideList(nums,mid+1,end);
            mergeList(nums,start,mid,end);
        }
    }
    /**
     * 因为需要使用下标直接修改数组中的元素，因此需要采用一个辅助数组temp来完成
     */
    public void mergeList(int[] nums , int start , int mid , int end){
        int[] temp = new int[nums.length];
        int p = start;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end){
            if(nums[i] < nums[j]){
                temp[p++] = nums[i++];
            }else {
                temp[p++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[p++] = nums[i++];
        }
        while (j <= end){
            temp[p++] = nums[j++];
        }
        for (int k = start; k <= end; k++) {
            nums[k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {49,38,65,97,76,13,27};
        S912_sortArray ss = new S912_sortArray();
        List<Integer> arr = ss.sortArray(nums);
        for (int i:arr) {
            System.out.println(i);
        }
    }
}

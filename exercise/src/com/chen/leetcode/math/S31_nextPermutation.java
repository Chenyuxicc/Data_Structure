package com.chen.leetcode.math;

import java.util.Arrays;


/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/9 on 21:43
 * 找到第一个nums[i-1] < nums[i] i后面的一定是降序
 * 再找到nums[i-1]后面第一个比nums[i-1]大的元素nums[j] 将nums[i-1]与nums[j]交换
 * 此时nums[i]及之后的数字依旧是降序的 将nums[i]及之后的数字进行反转
 * 得到最接近的数
 *
 * 升序的数是最小的
 **/
public class S31_nextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1 ; i > 0 ; i--) {
            if(nums[i] <= nums[i-1]){
                //已经是降序 则反转
                if(i == 1){
                    Arrays.sort(nums);
                    return;
                }
            }else {
                break;
            }
        }
        int index1 = 0;
        for (int i = nums.length - 1; i > 0 ; i--) {
            if(nums[i] > nums[i-1]){
                index1 = i-1;
                break;
            }
        }
        int index2 = 0;
        for (int i = index1 + 1; i <nums.length; i++) {
            //找到与nums[i-1]最接近的数
            if(nums[i] > nums[index1]){
                index2 = i;
            }
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        for (int i = index1 + 1 , j= 0; i <= (nums.length + index1) / 2; i++ , j++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length -1 -j];
            nums[nums.length - 1 -j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,7,5,3,2};
    }
}

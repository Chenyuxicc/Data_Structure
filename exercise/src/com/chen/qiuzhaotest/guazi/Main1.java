package com.chen.qiuzhaotest.guazi;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/4 on 15:44
 **/
public class Main1 {
    public static void minNum(int[] nums){
        for (int i = 0; i < nums.length; ) {
            if(i == 0){
                System.out.println("index:"+nums[0]);
            }
            int temp = nums[i];
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int j = i + 1; j <= temp+i; j++) {
                if(temp + j >= nums.length){
                    System.out.println("index:"+nums[i]);
                    return;
                }
                if(nums[j] + j > max){
                    max = nums[j] + j;
                    maxIndex = j;
                }
            }
            i = maxIndex;
            System.out.println("index:"+ nums[maxIndex]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,5,7,2,4,3,5,1,2,6,3};
        minNum(nums);
    }
}

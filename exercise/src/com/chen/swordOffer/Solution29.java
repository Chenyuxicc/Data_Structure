package com.chen.swordOffer;

import java.lang.Integer;
/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/23 on 21:10
 **/
//找出一个数组中和最大的子数组，并返回这个子数组的和
public class Solution29 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int curGreatestSum=Integer.MIN_VALUE;
        int curSum=0;
        int length=array.length;
        if(length<=0){
            return 0;
        }
        //一个curSum表示当前计算的子数组的和，一个curGreatestSum表示当前子数组的最大值
        for (int i = 0; i <length ; i++) {
            if(i==0||curSum<0){
                curSum=array[i];
            } else if(curSum>0){
                curSum+=array[i];
            }
            if(curSum>curGreatestSum){
                curGreatestSum=curSum;
            }
        }
        return curGreatestSum;
    }

    public static void main(String[] args) {
        int[] arr={1,-2,3,10,-4,7,2,-5};
        int max=FindGreatestSumOfSubArray(arr);
        System.out.println(max);
    }
}

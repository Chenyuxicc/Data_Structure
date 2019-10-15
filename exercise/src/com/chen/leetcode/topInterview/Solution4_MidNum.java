package com.chen.leetcode.topInterview;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/9 on 9:07
 **/
public class Solution4_MidNum {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 普通解法：算得中位数的位置，再进行比较排序，时间复杂度O(n)
         */
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return 0.0;
        }
        int length = nums1.length + nums2.length;
        int mid1 = 0;
        int mid2 = 0;
        if(length % 2 == 0){
            mid1 = length/2-1;
            mid2 = length/2;
        }else {
            mid2 = length/2;
        }
        int i = 0;
        int j = 0;
        int[] num = new int[mid2+1];
        int k = 0;
        for (; i < nums1.length && j < nums2.length && k < mid2+1 ;) {
            if(nums1[i] < nums2[j]){
                num[k++] = nums1[i++];
            }else {
                num[k++] = nums2[j++];
            }
        }
        while (k < mid2 + 1 && i == nums1.length){
            num[k++] = nums2[j++];
        }
        while (k < mid2 + 1 && j == nums2.length){
            num[k++] = nums1[i++];
        }
        return length % 2 == 0 ? (num[mid1]+num[mid2])/2.0 : (double) num[mid2];
    }
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        /**
         * 考虑中位数的本质，从其定义以及划分后的状态规律来思考
         * 中位数，按中位数划分后的两个子集大小相同，或者大小只相差一个元素，且前一个子集的元素都小于后一个子集的元素
         */
        int m = nums1.length;
        int n = nums2.length;
        int i = 0,j=0;
        //需要保证n>m此时才不会越界
        if(m > n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }
        int minS = 0;
        int maxS = m;
        while (minS <= maxS){
            i = (minS + maxS) / 2;
            j = (m + n + 1) / 2 - i;
            if(i < maxS && nums2[j - 1] > nums1[i]){
                //i太小了，需要在后半段搜索
                minS = i + 1;
            }else if(i > minS && nums1[i - 1] > nums2[j]){
                //i太大了，需要在前半段搜索
                maxS = i - 1;
            }else {
                int midLeft = 0;
                if(i == 0){
                    midLeft = nums2[j-1];
                }else if(j == 0){
                    midLeft = nums1[i-1];
                }else {
                    midLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n) % 2 == 1){
                    return midLeft;
                }
                int midRight = 0;
                if(i == m){
                    midRight = nums2[j];
                }else if(j == n){
                    midRight = nums1[i];
                }else {
                    midRight = Math.min(nums1[i],nums2[j]);
                }
                return (midLeft + midRight)/2.0;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] num2 = {2};
        Solution4_MidNum solution4midNum = new Solution4_MidNum();
        System.out.println(solution4midNum.findMedianSortedArrays1(num1,num2));
    }
}

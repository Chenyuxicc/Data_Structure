package com.chen.leetcode.dp;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:06
 */
public class Solution123 {
    /**
     * 可以买卖两次股票，求买入与卖出的最佳时机，使得收益最大
     * [10,22,5,75,65,80]
     */
    public int maxProfit1(int[] prices) {
        int dp_i10 = 0,dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0,dp_i21 = Integer.MIN_VALUE;
        for (int price:prices) {
            dp_i20 = Math.max(dp_i20,dp_i21 + price);
            dp_i21 = Math.max(dp_i21,dp_i10 - price);
            dp_i10 = Math.max(dp_i10,dp_i11 + price);
            dp_i11 = Math.max(dp_i11,-price);
        }
        Object ob = new Object();
        return dp_i20;
    }
    /**
     * 更为常见的一种解法，考虑使用i进行划分，i前面的求买入与卖出的最大值，i后面的数组求买入和卖出的最大值
     * 再求出每一种i划分的情况下，收益的最大值
     */
    public static int maxProfit2(int[] prices){
        int length = prices.length;
        int[] leftProfit = new int[length];
        int[] rightProfit = new int[length];

        //左边数组的最小值，初值为prices[0]
        int leftMin = prices[0];
        //右边数组的最大值,初值为prices[length - 1]
        int rightMax = prices[length - 1];

        int sum = 0;
        //遍历左边的数组
        for (int i = 1; i < length; i++) {
            leftMin = Math.min(prices[i],leftMin);
            //两种情况，第一种i天卖出，第二种不卖出，还是为第i-1天的情况
            //leftProfit[i]表示第i天的最大收入
            leftProfit[i] = Math.max(prices[i] - leftMin , leftProfit[i]);
        }

        for (int i = length - 2; i >= 0 ; i--) {
            rightMax = Math.max(prices[i],rightMax);
            //两种情况，第i天买入，此时需要花费-prices[i] 第i天不买入，那就是第i-1天买入的最佳情况
            rightProfit[i] = Math.max(rightMax - prices[i] , rightProfit[i + 1]);
        }

        for (int i = 0; i < length; i++) {
            sum = Math.max(sum,leftProfit[i]+ rightProfit[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {10,22,5,75,65,80};
        System.out.println(maxProfit2(prices));
    }
}

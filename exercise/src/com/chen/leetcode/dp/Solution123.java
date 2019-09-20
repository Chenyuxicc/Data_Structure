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
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0 || length == 1){
            return 0;
        }
        //用来保存prices[i]之前的最小的price
        int minLeft = prices[0];
        //用来保存从第0天到第i天 买卖一次收益最大值
        int[] leftProfit = new int[length];

        //记录每一次从0天到第i天 买卖一次的收益最大值
        for(int i = 1 ; i < length ; i ++){
            //两种情况：不操作，结果为上一次结果；将股票卖出最好的情况，使用当前的股票价格减去之前的最小值
            //取两者情况中的最大值
            //出口条件：leftProfit[0] = 0 不进行买卖情况下，收益为0
            leftProfit[i] = Math.max(leftProfit[i - 1] , prices[i] - minLeft);
            minLeft = Math.min(prices[i] , minLeft);
        }
        //表示已遍历的元素中的最大值
        int maxRight = prices[length - 1];

        //用来保存从第i天到最后一天 买卖一次的最大收益
        int[] rightProfit = new int[length];

        for(int i = length - 2 ; i >= 0 ; i --){
            rightProfit[i] = Math.max(rightProfit[i + 1] , maxRight - prices[i]);
            maxRight = Math.max(prices[i] , maxRight);
        }

        int sum = 0;
        for(int i = 0 ; i < length ; i++){
            sum = Math.max(sum , leftProfit[i] + rightProfit[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {10,22,5,75,65,80};
        System.out.println(maxProfit2(prices));
    }
}

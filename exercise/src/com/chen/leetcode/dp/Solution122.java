package com.chen.leetcode.dp;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:06
 */
public class Solution122 {
    /**
     * 1.一天之内可以先卖出再买入
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
    //可以多次购买以及卖出
    //新状态只和相邻的状态有关系，不需要存储全局的状态，可以不使用数组，只使用变量
    public int maxProfit2(int[] prices){
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int length = prices.length;
        for (int i = 0; i < length ; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,temp - prices[i]);
        }
        return dp_i_0;
    }
}


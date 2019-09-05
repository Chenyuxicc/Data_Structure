package com.chen.leetcode.dp;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:06
 */
public class Solution121 {
    /**
     * 1.题目中举的第二个例子，没有完成交易的原因：卖出价格必须大于买入价格，第二个例子当中所有的卖出价格都会小于买入价格，所以不会卖出
     * 2.状态方程f(i) = max{f(i-1),prices[i] - min}
     * 3.使用max记录当前最大值，使用min记录prices中最小值
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length ; i++) {
            max = Math.max(max,prices[i] - min);
            min = Math.min(prices[i] , min);
        }
        return max;
    }
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        //第一个表示是第几天，第二个表示当天的状态是持有股票还是不持有，持有为1，不持有为0
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            if(i == 0){
                //第一天没有买入，利润为0
                dp[0][0] = 0;
                //第一天买入了，花了prices[0]的钱，利润为-prices[0]
                dp[0][1] = -prices[0];
                continue;
            }
            //状态转移，第i天没有股票的最大利润为前i-1天后没有持有股票的利润和前i-1天有股票但是第i天卖出的最大值
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][i] + prices[i]);
            //第i天有股票的最大利润，前i-1天有股票，第i天没有变化，以及前i-1天没有股票，在第i天买入,花费prices[i]
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        //最后一天应该是没有持有股票的。
        return dp[length-1][0];
    }

    //新状态只和相邻的状态有关系，不需要存储全局的状态，可以不使用数组，只使用变量
    public int maxProfit2(int[] prices){
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int length = prices.length;
        for (int i = 0; i < length ; i++) {
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1,-prices[i]);
        }
        return dp_i_0;
    }
}


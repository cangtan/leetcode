package com.leetcode.dp.problem;

/**
 * 买股票的最佳时机含手续费
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-26 15:44:00
 */
public class Solution714 {
    /**
     * 定义dp[i][0]表示手中没有股票时的最大利润
     * 定义dp[i][1]表示手中持有股票时的最大利润
     * <p>
     * dp[i][0]可能来源值为前一天就已经没有股票了即dp[i-1][0]
     * 或者前一天持有股票,今天需要将其卖出即dp[i-1][1]+prices[i]-fee
     * <p>
     * dp[i][1]可能来源为前一天就持有股票了,今天继续持有即dp[i-1][1]
     * 或者前一天没有持有股票,今天持有即dp[i-1][0] - prices[i]
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        Solution714 solution = new Solution714();
        int[] prices = {9, 8, 7, 1, 2};
        int fee = 3;
        System.out.println(solution.maxProfit(prices, fee));
    }
}

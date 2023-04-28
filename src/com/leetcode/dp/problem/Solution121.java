package com.leetcode.dp.problem;

/**
 * 买卖股票的最佳时机
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-18 10:25:00
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int prev = prices[0];
        int result = 0;
        for (int price : prices) {
            result = Math.max(price - prev, result);
            prev = Math.min(prev, price);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        // 0 表示买入
        dp[0][0] = prices[0];
        // 1 表示卖出
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 我们希望买入的价格越低越好
            dp[i][0] = Math.min(dp[i - 1][0], prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        Solution121 solution = new Solution121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit2(prices));
    }
}

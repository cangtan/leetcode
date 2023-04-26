package com.leetcode.dp.problem;

import java.util.Arrays;

/**
 * 买卖股票的最佳时机 IV
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-24 10:12:00
 */
public class Solution188 {
    /**
     * 第i天买,第in天卖
     * 第j > i天买 第jn天卖出
     */
    public int maxProfit(int k, int[] prices) {
        int[][] buy = new int[prices.length][k + 1];
        int[][] sell = new int[prices.length][k + 1];
        buy[0][0] = -prices[0];
        k = Math.min(k, prices.length / 2);
        for (int i = 1; i <= k; i++) {
            buy[0][i] = Integer.MIN_VALUE + 1000;
            sell[0][i] = Integer.MIN_VALUE + 1000;
        }
        for (int i = 1; i < prices.length; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[prices.length - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        Solution188 solution = new Solution188();
        int k = 2;
        int[] prices = {2, 4, 1};
        System.out.println(solution.maxProfit(k, prices));
    }
}

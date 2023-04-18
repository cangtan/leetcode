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

    public static void main(String[] args) {
        Solution121 solution = new Solution121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }
}

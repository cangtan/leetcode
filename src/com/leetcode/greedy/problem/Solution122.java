package com.leetcode.greedy.problem;

/**
 * 买卖股票的最佳时机II
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-07 14:13:00
 */
public class Solution122 {

    public int maxProfit(int[] prices) {
        int earn = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                earn += prices[i + 1] - prices[i];
            }
        }
        return earn;
    }
    public int maxProfit2(int[] prices) {
        int profit = 0;
        boolean isHold = false;
        int holdIndex = -1;
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length) {
                if (prices[i] < prices[i + 1] && !isHold) {
                    // 知道了明天会涨,而且还没买, 那就买
                    holdIndex = i;
                    isHold = true;
                } else if (prices[i] > prices[i + 1] && isHold) {
                    // 大于，但后续降价,抛售
                    profit += prices[i] - prices[holdIndex];
                    isHold = false;
                }
            } else if (isHold) {
                profit += prices[i] - prices[holdIndex];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution122 solution = new Solution122();
        int[] prices = {1, 2, 3,4,5 };
        System.out.println(solution.maxProfit(prices));
    }
}

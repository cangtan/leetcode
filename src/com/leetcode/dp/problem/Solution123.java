package com.leetcode.dp.problem;

/**
 * 买卖股票的最佳时机III
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-18 13:46:00
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        int[] dpLeft = new int[length];
        int[] dpRight = new int[length];
        int prev = prices[0];
        for (int i = 1; i < length; i++) {
            dpLeft[i] = Math.max(prices[i] - prev, dpLeft[i - 1]);
            prev = Math.min(prev, prices[i]);
        }
        prev = prices[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            dpRight[i] = Math.min(prices[i] - prev, dpRight[i + 1]);
            prev = Math.max(prev, prices[i]);
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max(dpLeft[i] + Math.abs(dpRight[i]), result);
        }
        return result;
    }

    /**
     * 官方题解
     * 由于我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于以下五个状态中的一种：
     * 未进行过任何操作；
     * 只进行过一次买操作；
     * 进行了一次买操作和一次卖操作，即完成了一笔交易；
     * 在完成了一笔交易的前提下，进行了第二次买操作；
     * 完成了全部两笔交易。
     * 由于第一个状态的利润显然为 00，因此我们可以不用将其记录。对于剩下的四个状态，我们分别将它们的最大利润记为 buy1，sell1，buy2，以及 sell2
     * 对于 buy1而言，在第 ii 天我们可以不进行任何操作，保持不变，也可以在未进行任何操作的前提下以 prices[i] 的价格买入股票，那么buy1的状态转移方程即为：
     * buy1 = max(buy'1, -prices[i]) “用buy'1表示i-1天的状态”
     * 对于 sell1而言，在第 ii 天我们可以不进行任何操作，保持不变，也可以在只进行过一次买操作的前提下以 prices[i] 的价格卖出股票，那么sell1的状态转移方程即为：
     * sell1 = max(sell'1, buy'1 + prices[i])
     * 同理得buy2和sell2
     *
     * @author LeetCode-Solution
     * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/">官方题解</a>
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        Solution123 solution = new Solution123();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = {7,6,4,3,1};

        System.out.println(solution.maxProfit(prices));
    }
}

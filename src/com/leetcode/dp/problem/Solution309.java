package com.leetcode.dp.problem;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-18 15:02:00
 */
public class Solution309 {
    /**
     * f(i)用以表示第i天结束之后的[累计最大收益]
     * 最多持有一支股票，并且卖出去后有冷冻期的限制，因此会有三种不同的状态
     * 1.目前持有一支股票，对应的累计最大收益记为f[i][0]
     * 2.目前不持有股票，并且处在冷冻期中，对应的累计最大收益记为f[i][1]
     * 3.目前不持有股票，并且不处在冷冻期中，对应的累计最大收益记为f[i][2]
     * <p>
     * 分别对三种状态进行分析
     * 1.对于f[i][0]，我们目前持有的这一支股票是在第i-1天就已经持有的了，对应的状态为f[i-1][0]；或者是第i天买入的，那么第i-1天就不能持有股票
     * 并且不处于冷冻期中,对应的状态为f[i-1][2]加上买入股票的负收益prices[i]。因此状态方程为
     * f[i][0] = max(f[i-1][0], f[i-1][2] - prices[i])
     * 2.对于f[i][1]，我们在第i天结束之后处于冷冻期是因为当天卖出了股票，那么说明在第 i-1 天时我们必须持有一支股票，对应的状态为f[i-1][0]
     * 加上卖出股票的正收益prices[i]。因此状态转移方程为
     * f[i][1] = f[i-1][0]+prices[i]
     * 3.对于f[i][2]，我们在第i天结束之后不持有任何股票并且不处于冷冻期，说明当天没有进行任何操作，即第 i-1 天时不持有任何股票：如果处于冷冻期
     * 对应的状态f[i-1][1]；如果不处于冷冻期，对应的状态f[i-1][2]。因此状态转移方程为
     * f[i][2] = max(f[i-1][1], f[i-1][2])
     * <p>
     * 最终答案即 max(f[n-1][1], f[n-1][2])
     * 边界
     * f[0][0]=-prices[0]
     * f[0][1]=0
     * f[0][2]=0
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[length - 1][1], dp[length - 1][2]);
    }

    public static void main(String[] args) {
        Solution309 solution = new Solution309();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(solution.maxProfit(prices));
    }
}

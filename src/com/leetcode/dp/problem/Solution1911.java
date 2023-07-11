package com.leetcode.dp.problem;

/**
 * 最大子序列交替和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-11 11:06:00
 */
public class Solution1911 {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        // 表示正数，偶数
        dp[0][0] = nums[0];
        // 表示负数
        dp[0][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], nums[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i]);
        }
        return dp[nums.length - 1][0];
    }

    public static void main(String[] args) {
        Solution1911 solution = new Solution1911();
        int[] nums = {4,2,5,3};
        System.out.println(solution.maxAlternatingSum(nums));
    }
}

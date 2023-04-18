package com.leetcode.dp.problem;

/**
 * 打家劫舍
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-14 16:10:00
 */
public class Solution198 {

    /**
     * 状态转移方程
     * dp[i] = max(dp[i-2]+nums[i], dp[i-1])
     * 边界条件
     * dp[0]=nums[0]
     * dp[1]=max(nums[0], nums[1])
     *
     * @author LeetCode-Solution
     * @see <a href="https://leetcode.cn/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/">官方题解</a>
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int prev2 = 0;
            if (i - 2 >= 0) {
                prev2 = dp[i - 2] + nums[i];
            }
            int prev3 = 0;
            if (i - 3 >= 0) {
                prev3 = dp[i - 3] + nums[i];
            }
            dp[i] = Math.max(prev2, Math.max(prev3, nums[i]));
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution198 solution = new Solution198();
        int[] nums = {2, 1, 1, 2};
        // f(1) = 2
        // f(2) = Math.max(2, 1)
        // f(3) = Math.max(2+1, 1)
        // f(4) = Math.max(2+2, 2+1, 2+1, 2+2)
        System.out.println(solution.rob(nums));
    }
}

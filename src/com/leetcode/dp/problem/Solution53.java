package com.leetcode.dp.problem;

/**
 * 最大子数组和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-13 15:54:00
 */
public class Solution53 {

    /**
     * 动态规划方程
     * f(i) = max{f(i - 1) + nums[i], nums[i]}
     *
     */
    public int maxSubArray(int[] nums) {
        // DP
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int maxSubArrayForce(int[] nums) {
        // 暴力
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cache = nums[i];
            max = Math.max(max, cache);
            for (int j = i + 1; j < nums.length; j++) {
                cache += nums[j];
                max = Math.max(max, cache);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
}

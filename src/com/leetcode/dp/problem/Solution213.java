package com.leetcode.dp.problem;

/**
 * 打家劫舍II
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-17 16:46:00
 */
public class Solution213 {

    /**
     * 区别于I在于如果偷了第一间，则不能偷最后一间
     * 如果偷了最后一间，则不能偷第一间
     * 将数组分为两部分[0, n-2], [1,n-1]
     * 求最大值
     *
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 第一部分
        int first = nums[0];
        int second = Math.max(first, nums[1]);
        int max = second;
        for (int i = 2; i <= nums.length - 2; i++) {
            int temp = second;
            second = Math.max(first + nums[i], temp);
            first = temp;
            max = Math.max(max, second);
        }
        first = 0;
        second = nums[1];
        for (int i = 2; i <= nums.length - 1; i++) {
            int temp = second;
            second = Math.max(first + nums[i], temp);
            first = temp;
            max = Math.max(max, second);
        }

        return max;
    }

    /**
     * 官方题解
     *
     * @author LeetCode-Solution
     * @see <a href="https://leetcode.cn/problems/house-robber-ii/solution/da-jia-jie-she-ii-by-leetcode-solution-bwja/">官方题解</a>
     */
    public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        Solution213 solution = new Solution213();
        int[] nums = {2,1,1,2};
        System.out.println(solution.rob(nums));
    }
}

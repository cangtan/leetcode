package com.leetcode.greedy.problem;

/**
 * 跳跃游戏
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-07 17:40:00
 */
public class Solution55 {
    /**
     * 从正向无法进行贪心
     * 但是从后往前可以进行贪心，判断前一位是否可以达到当前位置
     */
    public boolean canJump(int[] nums) {
        int enableReach = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= enableReach) {
                enableReach = i;
            }
        }
        return enableReach == 0;
    }

    public static void main(String[] args) {
        Solution55 solution = new Solution55();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums));
    }
}

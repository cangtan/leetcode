package com.leetcode.greedy.problem;

/**
 * 跳跃游戏II
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-07 17:48:00
 */
public class Solution45 {
    /**
     * 反向贪心
     * 判断能达到当前位置最远的一个下标
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int position = nums.length - 1;
        int result = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 正向贪心，每次选取跳跃达到的最远距离
     */
    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int length = nums.length - 1;
        int end = 0;
        int maxPosition = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (end == i) {
                end = maxPosition;
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution45 solution = new Solution45();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.jump2(nums));
    }
}

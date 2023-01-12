package com.leetcode.other.problem;

import com.leetcode.array.problem.Solution792;

/**
 * 区间子数组个数
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-24 09:52:00
 */
public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 一次遍历
        int result = 0;
        int last1 = -1;
        int last2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                result += last1 - last2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution795 solution = new Solution795();
        int[] nums = {2, 9, 2, 5, 6};
        int left = 2;
        int right = 8;
        System.out.println(solution.numSubarrayBoundedMax(nums, left, right));
    }
}

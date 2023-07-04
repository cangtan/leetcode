package com.leetcode.array.problem;

import java.util.Arrays;

/**
 * 矩阵中的和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-04 09:35:00
 */
public class Solution2679 {

    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int result = 0;
        int[] max = new int[nums[0].length];
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                max[j] = Math.max(nums[i][j], max[j]);
            }
        }
        for (int i : max) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2679 solution = new Solution2679();
        int[][] nums = {
                {7, 2, 1},
                {6, 4, 2},
                {6, 5, 3},
                {3, 2, 1},
        };
        System.out.println(solution.matrixSum(nums));
    }
}

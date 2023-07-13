package com.leetcode.dp.problem;

/**
 * 下降路径最小和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-13 09:36:00
 */
public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = dp[i - 1][j];
                if (j - 1 >= 0) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j + 1 < n) {
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                dp[i][j] = min + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution931 solution = new Solution931();
        int[][] matrix = test2();
        System.out.println(solution.minFallingPathSum(matrix));
    }

    private static int[][] test1() {
        return new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
    }

    private static int[][] test2() {
        return new int[][]{
                {17, 82},
                {1, -44}
        };
    }
}

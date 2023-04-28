package com.leetcode.dp.problem;

/**
 * 最小路径和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-28 13:42:00
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[n][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1][col - 1];
    }

    public static void main(String[] args) {
        Solution64 solution = new Solution64();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
//        int[][] grid = {
//                {1, 2, 3},
//                {4, 5, 6}
//        };
        System.out.println(solution.minPathSum(grid));
    }
}

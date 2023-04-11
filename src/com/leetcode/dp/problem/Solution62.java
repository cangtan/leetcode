package com.leetcode.dp.problem;

/**
 * 不同路径
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-11 11:12:00
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] opt = new int[m][n];
        for (int i = 0; i < n - 1; i++) {
            opt[m - 1][i] = 1;
        }
        for (int i = 0; i < m - 1; i++) {
            opt[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                opt[i][j] = opt[i + 1][j] + opt[i][j + 1];
            }
        }
        return opt[0][0];
    }

    public static void main(String[] args) {
        Solution62 solution = new Solution62();
        int m = 1;
        int n = 1;
        System.out.println(solution.uniquePaths(m, n));
    }
}

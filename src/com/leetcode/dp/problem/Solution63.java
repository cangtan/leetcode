package com.leetcode.dp.problem;

/**
 * 不同路径II
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-11 11:32:00
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] opt = new int[m][n];
        opt[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    opt[i][j] = 0;
                } else {
                    if (i + 1 < m && obstacleGrid[i + 1][j] == 0) {
                        opt[i][j] += opt[i + 1][j];
                    }
                    if (j + 1 < n && obstacleGrid[i][j + 1] == 0) {
                        opt[i][j] += opt[i][j + 1];
                    }
                }
            }
        }
        return opt[0][0];
    }

    /**
     * 官方题解
     *
     * @author LeetCode-Solution
     * @see <a href="https://leetcode.cn/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/">官方题解</a>
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }


    public static void main(String[] args) {
        Solution63 solution = new Solution63();
        int[][] obstacleGrid = {
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles2(obstacleGrid));
    }
}

package com.leetcode.recursion.problem;

/**
 * 检查骑士巡查方案
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-09-13 14:36:00
 */
public class Solution2596 {

    private final int[] forwardI = {1, 1, 2, 2, -1, -1, -2, -2};

    private final int[] forwardJ = {2, -2, 1, -1, 2, -2, 1, -1};


    public boolean checkValidGrid(int[][] grid) {
        int n = grid[0].length;
        if (grid[0][0] != 0) {
            return false;
        }
        return dfs(grid, 0, 0, 1, n);
    }

    public boolean dfs(int[][] grid, int i, int j, int next, int n) {
        if (next >= n * n) {
            return true;
        }
        for (int k = 0; k < 8; k++) {
            int i1 = forwardI[k] + i;
            int j1 = forwardJ[k] + j;
            if (i1 >= 0 && j1 >= 0 && j1 < n && i1 < n && grid[i1][j1] == next) {
                return dfs(grid, i1, j1, next + 1, n);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2596 solution = new Solution2596();
        int[][] grid = case2();
        System.out.println(solution.checkValidGrid(grid));
    }

    public static int[][] case1() {
        return new int[][]{
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        };
    }

    public static int[][] case2() {
        return new int[][]{
                {24, 11, 22, 17, 4},
                {21, 16, 5, 12, 9},
                {6, 23, 10, 3, 18},
                {15, 20, 1, 8, 13},
                {0, 7, 14, 19, 2}
        };
    }
}

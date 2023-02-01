package com.leetcode.other.problem;


/**
 * 判断矩阵是否是一个X矩阵
 *
 * @author 薛佳豪
 * @version V1.0
 * @since 2023-01-31 16:57:00
 */
public class Solution2319 {
    public boolean checkXMatrix(int[][] grid) {
        int c = grid[0].length - 1;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if ((x - c == -y || -y == -x) && grid[y][x] == 0) {
                    if (grid[y][x] == 0) {
                        return false;
                    }
                } else {
                    if (grid[y][x] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2319 solution = new Solution2319();
        int[][] grid = {{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        System.out.println(solution.checkXMatrix(grid));
    }
}

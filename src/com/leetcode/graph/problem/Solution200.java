package com.leetcode.graph.problem;

/**
 * 岛屿数量
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-07 10:57:00
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        boolean[][] booleans = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !booleans[i][j]) {
                    result++;
                    numIslandsHelper(grid, booleans, i, j);
                }
            }
        }
        return result;
    }

    public void numIslandsHelper(char[][] grid, boolean[][] booleans, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || booleans[i][j]) {
            return;
        }
        booleans[i][j] = true;
        numIslandsHelper(grid, booleans, i - 1, j);
        numIslandsHelper(grid, booleans, i + 1, j);
        numIslandsHelper(grid, booleans, i, j - 1);
        numIslandsHelper(grid, booleans, i, j + 1);
    }

    /**
     * 并查集
     */
    public int numIslandsUF(char[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int idx = i * col + j;
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        uf.union(idx, (i + 1) * col + j);
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        uf.union(idx, idx + 1);
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(char[][] grid) {
            int rows = grid.length;
            int col = grid[0].length;
            int n = rows * col;
            parent = new int[n];
            count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * col + j] = i * col + j;
                        count++;
                    }
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if (x == y) {
                return;
            }
            parent[x] = parent[y];
            count--;
        }
    }

    public static void main(String[] args) {
        Solution200 solution = new Solution200();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
//        System.out.println(grid.length);
        System.out.println(solution.numIslandsUF(grid));
    }
}

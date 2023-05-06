package com.leetcode.disjointset.problem;

/**
 * 省份数量
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-06 15:17:00
 */
public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                result++;
            }
        }
        return result;
    }

    private void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = parent[find(parent, j)];
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    public static void main(String[] args) {
        Solution547 solution = new Solution547();
        int[][] isConnected = test3();
        System.out.println(solution.findCircleNum(isConnected));
    }

    private static int[][] test1() {
        return new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
    }

    private static int[][] test2() {
        return new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
    }

    private static int[][] test3() {
        return new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
    }
}

package com.leetcode.graph.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二进制矩阵中的最短路径
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-15 11:31:00
 */
public class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        return -1;
    }
    public int shortestPathBinaryMatrixBFS(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        } else if (n <= 2) {
            return n;
        }
        boolean[][] visitied = new boolean[n][n];
        visitied[0][0] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        int[][] dists = {
                {1, 1},
                {1, 0},
                {0, 1},
                {1, -1},
                {-1, 1},
                {-1, 0},
                {-1, -1},
                {0, -1}
        };
        int result = 1;
        int size = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            size--;
            for (int[] dist : dists) {
                int x = node.getX() + dist[0];
                int y = node.getY() + dist[1];
                if (x == n - 1 && y == n - 1) {
                    return result + 1;
                }
                if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0 && !visitied[x][y]) {
                    queue.add(new Node(x, y));
                    visitied[x][y] = true;
                }
            }
            if (size == 0) {
                result++;
                size = queue.size();
            }
        }
        return -1;
    }

    static class Node {
        private final int x;
        private final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        Solution1091 solution = new Solution1091();
        int[][] grid = test5();
        System.out.println(solution.shortestPathBinaryMatrixBFS(grid));
    }

    public static int[][] test1() {
        return new int[][]{
                {0, 1},
                {1, 0},
        };
    }

    public static int[][] test2() {
        return new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
    }

    public static int[][] test3() {
        return new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
    }

    public static int[][] test5() {
        return new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
    }

    public static int[][] test4() {
        return new int[][]{
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
    }
}

package com.leetcode.disjointset.problem;

/**
 * 被围绕的区域
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-06 17:44:00
 */
public class Solution130 {
    public void solve(char[][] board) {
        int rows = board.length;
        int col = board[0].length;
        int n = rows * col;
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == rows - 1 || j == 0 || j == col - 1) {
                        union(parent, i * col + j, n);
                    } else {
                        if (board[i - 1][j] == 'O') {
                            union(parent, i * col + j, (i - 1) * col + j);
                        }
                        if (i + 1 < rows && board[i + 1][j] == 'O') {
                            union(parent, i * col + j, (i + 1) * col + j);
                        }
                        if (board[i][j - 1] == 'O') {
                            union(parent, i * col + j, i * col + j - 1);
                        }
                        if (j + 1 < col && board[i][j + 1] == 'O') {
                            union(parent, i * col + j, i * col + j + 1);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (isConnected(parent, i * col + j, n)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
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

    private boolean isConnected(int[] parent, int i, int j) {
        return find(parent, parent[i]) == find(parent, parent[j]);
    }

    public static void main(String[] args) {
        Solution130 solution = new Solution130();
        char[][] board = test4();
        solution.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] test1() {
        return new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
    }

    public static char[][] test2() {
        return new char[][]{
                {'O', 'O'},
                {'O', 'O'}
        };
    }

    public static char[][] test3() {
        return new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
    }

    public static char[][] test4() {
        return new char[][]{
                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'O'},
                {'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X', 'X', 'O', 'O', 'X', 'X', 'X'},
                {'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O'}
        };
    }
}

package com.leetcode.array.problem;

/**
 * 有效的数独
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-10 11:45:00
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] area = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    row[i][num]++;
                    col[j][num]++;
                    area[i / 3][j / 3][num]++;
                    if (row[i][num] > 1 || col[j][num] > 1 || area[i / 3][j / 3][num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution36 solution = new Solution36();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board));
    }
}

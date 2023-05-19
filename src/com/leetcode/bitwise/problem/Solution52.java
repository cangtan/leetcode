package com.leetcode.bitwise.problem;

/**
 * N皇后II
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-17 15:04:00
 */
public class Solution52 {
    int size;
    int count;

    public int totalNQueens(int n) {
        this.size = (1 << n) - 1;
        this.count = 0;
        solve(0, 0, 0);
        return this.count;
    }

    private void solve(int row, int pie, int na) {
        if (row == size) {
            this.count += 1;
            return;
        }
        int pos = size & (~(row | pie | na));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            solve(row | p, (pie | p) << 1, (na | p) >> 1);
        }
    }

    public static void main(String[] args) {

        Solution52 solution = new Solution52();
        System.out.println(solution.totalNQueens(4));
    }
}

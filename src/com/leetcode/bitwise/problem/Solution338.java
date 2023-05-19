package com.leetcode.bitwise.problem;

/**
 * 比特位计数
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-19 10:51:00
 */
public class Solution338 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution338 solution = new Solution338();
        System.out.println(solution.countBits(4));
        // 0
        // 1  1
        // 10  1 + 0  = 1
        // 11 1 + 1 = 2
        // 100 1 + 0 = 1
        // 101 1+ 1 = 2
        // 110 2 + 1
    }
}

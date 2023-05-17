package com.leetcode.bitwise.problem;

/**
 * 2的幂
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-17 13:38:00
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution231 solution = new Solution231();
        System.out.println(solution.isPowerOfTwo(1));
    }
}

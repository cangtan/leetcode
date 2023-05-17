package com.leetcode.bitwise.problem;

/**
 * 位1的个数
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-17 11:01:00
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n > 0) {
            result++;
            n &= n - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution191 solution = new Solution191();
        int n = 521;
        System.out.println(solution.hammingWeight(n));
    }
}

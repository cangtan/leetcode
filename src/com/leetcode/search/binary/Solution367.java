package com.leetcode.search.binary;

/**
 * 有效的完全平方数
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-10 14:58:00
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 0;
        int right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution367 solution = new Solution367();
        int num = 15;
        System.out.println(solution.isPerfectSquare(num));
    }
}

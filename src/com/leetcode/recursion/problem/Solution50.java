package com.leetcode.recursion.problem;

/**
 * Pow(x,n)
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-12-06 16:54:00
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (n < 0) {
            int abs = Math.abs(n / 2);
            double v = myPow(x, abs);
            return 1 / (v * v * myPow(x, Math.abs(n % 2)));
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double v = myPow(x, n / 2);
        return v * v * myPow(x, n % 2);
    }

    public static void main(String[] args) {
        Solution50 solution = new Solution50();
        double x = 2d;
        int n = -2147483648;
        System.out.println(solution.myPow(x, n));
    }
}

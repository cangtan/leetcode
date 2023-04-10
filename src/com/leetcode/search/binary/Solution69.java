package com.leetcode.search.binary;

/**
 * x的平方根
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-10 10:00:00
 */
public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x / 2 + 1;
        while (left <= right) {
            // 防止越界
            int mid = left + (right - left) / 2;
            long calc = (long) mid * mid;
            if (calc > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x / 2 + 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            long calc = (long) mid * mid;
            if (calc > x) {
                right = mid - 1;
            } else {
                if (calc == x) {
                    return mid;
                }
                left = mid + 1;
                long bigger = (long) left * left;
                if (bigger > x) {
                    return mid;
                }
            }
        }
        return mid;
    }

    /**
     * 牛顿迭代法
     */
    public int mySqrt3(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        Solution69 solution = new Solution69();
        int x = 2147483647;
//        int x = 4;
        System.out.println(solution.mySqrt3(x));
    }
}

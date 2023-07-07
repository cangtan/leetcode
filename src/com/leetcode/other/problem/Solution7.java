package com.leetcode.other.problem;

/**
 * 整数反转
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-07 16:01:00
 */
public class Solution7 {
    public int reverse(int x) {
        int temp = x;
        int result = 0;
        while (temp != 0) {
            int i = temp % 10;
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            } else {
                result = result * 10 + i;
            }
            temp = temp / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(solution.reverse(1563847412));
    }
}

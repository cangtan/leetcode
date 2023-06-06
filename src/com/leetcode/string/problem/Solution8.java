package com.leetcode.string.problem;

/**
 * 8.字符串转换整数
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-05 18:01:00
 */
public class Solution8 {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        boolean isPositive = true;
        int index = 0;
        int n = chars.length;
        while (index < n && chars[index] == ' ') {
            index++;
        }
        if (index < n && (chars[index] == '+' || chars[index] == '-')) {
            isPositive = chars[index] == '+';
            index++;
        }
        while (index < n && chars[index] >= '0' && chars[index] <= '9') {
            int digit = chars[index] - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return Integer.MAX_VALUE;
            } else if (result < (Integer.MIN_VALUE + digit) / 10) {
                return Integer.MIN_VALUE;
            }
            result = isPositive ? result * 10 + digit : result * 10 - digit;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution8 solution = new Solution8();
        String s = "-99999999999";
        System.out.println(solution.myAtoi(s));
    }
}

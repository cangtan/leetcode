package com.leetcode.string.problem;

import java.util.Arrays;

/**
 * 反转字符串
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-06 14:02:00
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution344 solution = new Solution344();
        char[] s = {'h','e','l','l','o'};
        solution.reverseString(s);
        for (char c : s) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}

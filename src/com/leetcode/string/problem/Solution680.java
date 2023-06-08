package com.leetcode.string.problem;

/**
 * 验证回文串II
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-08 13:43:00
 */
public class Solution680 {

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (chars[left] != chars[right]) {
                return isPalindrome(chars, left + 1, right) || isPalindrome(chars, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while (left <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 暴力 无法通过
     */
    public boolean validPalindromeForce(String s) {
        char[] chars = s.toCharArray();
        if (isPalindromeForce(chars, null)) {
            return true;
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (isPalindromeForce(chars, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPalindromeForce(char[] chars, Integer jump) {
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (jump != null) {
                if (left == jump) {
                    left++;
                } else if (right == jump) {
                    right--;
                }
            }
            if (left <= right && chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution680 solution = new Solution680();
        String s = "abc";
        System.out.println(solution.validPalindrome(s));
    }
}

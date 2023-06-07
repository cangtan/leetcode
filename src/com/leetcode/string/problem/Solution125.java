package com.leetcode.string.problem;

/**
 * 验证回文串
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-07 16:42:00
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution125 solution = new Solution125();
        String s = "0P";
        System.out.println(solution.isPalindrome(s));
    }
}

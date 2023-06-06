package com.leetcode.string.problem;

/**
 * 反转字符串II
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-06 14:13:00
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int left = 0;
        while (s.length() - left > 0) {
            reverseString(chars, left, k);
            left += 2 * k;
        }
        return new String(chars);
    }

    private void reverseString(char[] s, int left, int k) {
        int length = s.length - left;
        int right = left + k - 1;
        if (length < k) {
            right = s.length - 1;
        }
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution541 solution = new Solution541();
        String s = "abcdefg";
        int k = 4;
        System.out.println(solution.reverseStr(s, k));
    }
}

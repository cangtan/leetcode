package com.leetcode.string.problem;

/**
 * 仅仅反转字母
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-07 10:39:00
 */
public class Solution917 {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isLetter(chars[left])) {
                left++;
            }
            while (right > left && !isLetter(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static void main(String[] args) {
        Solution917 solution = new Solution917();
        String s = "a-bC-dEf-ghIj";
        System.out.println(solution.reverseOnlyLetters(s));
    }
}

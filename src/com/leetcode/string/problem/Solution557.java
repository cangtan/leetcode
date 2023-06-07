package com.leetcode.string.problem;

/**
 * 反转字符串中的单词III
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-07 10:26:00
 */
public class Solution557 {
    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int left = -1;
        int right = chars.length - 1;
        for (int i = 0; i <= right; i++) {
            if (chars[i] != ' ' && left == -1) {
                left = i;
            } else if (chars[i] == ' ') {
                swap(chars, left, i - 1);
                left = -1;
            } else if (i == right && left != -1) {
                swap(chars, left, i);
            }
        }
        return String.valueOf(chars);
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && chars[i] != ' ') {
                i++;
            }
            swap(chars, start, i - 1);
            while (i < length && chars[i] == ' ') {
                i++;
            }
        }
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution557 solution = new Solution557();
        String s = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(s));
    }
}

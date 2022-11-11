package com.leetcode.string.problem;

/**
 * 1704.判断字符串的两半是否相似
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/determine-if-string-halves-are-alike/">判断字符串的两半是否相似</a>
 * @since 2022-11-11 09:36:00
 */
public class Solution1704 {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = toLowerCase(s.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                if(i < mid) {
                    result++;
                } else {
                    result--;
                }
            }

        }
        return result == 0;
    }

    private char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) ('a' + (c - 'A'));
        }
        return c;
    }

    public static void main(String[] args) {
        String s = "AbCdEfGh";
        Solution1704 solution = new Solution1704();
        System.out.println(solution.halvesAreAlike(s));
    }
}

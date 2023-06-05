package com.leetcode.string.problem;

/**
 * 709. 转换成小写字母
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-05 16:40:00
 */
public class Solution709 {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= 'A' && aChar <= 'Z') {
                int ch = aChar - 'A' + 'a';
                chars[i] = (char) ch;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution709 solution = new Solution709();
        String s = "Hello";
        System.out.println(solution.toLowerCase(s));

    }
}

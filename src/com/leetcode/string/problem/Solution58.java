package com.leetcode.string.problem;

/**
 * 最后一个单词的长度
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-05 16:58:00
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        boolean hasCount = false;
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if ((chars[i] >= 'A' && chars[i] <= 'Z') || (chars[i] >= 'a' && chars[i] <= 'z')) {
                hasCount = true;
                count++;
            } else {
                if (hasCount) {
                    return count;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Solution58 solution = new Solution58();
        String str = "   fly me   to   the moon  ";
        System.out.println(solution.lengthOfLastWord(str));
    }
}

package com.leetcode.string.problem;

/**
 * 字符串中的第一个唯一字符
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-05 17:41:00
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        int[] bucket = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            bucket[aChar - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (bucket[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution387 solution = new Solution387();
        String s = "leetcode";
        System.out.println(solution.firstUniqChar(s));
    }
}

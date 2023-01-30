package com.leetcode.string.problem;

/**
 * 统计星号
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-29 11:16:00
 */
public class Solution2315 {
    public int countAsterisks(String s) {
        boolean isCount = true;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                isCount = !isCount;
            } else if(c == '*' && isCount) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2315 solution = new Solution2315();
        String s = "yo|uar|e**|b|e***au|tifu|l";
        System.out.println(solution.countAsterisks(s));
    }
}

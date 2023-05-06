package com.leetcode.other.problem;

/**
 * 最长平衡子字符串
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-06 11:53:00
 */
public class Solution2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                if (right > 0) {
                    right = 0;
                    left = 0;
                }
                left++;
            } else {
                right++;
            }
            if (right <= left) {
                max = Math.max(2 * right, max);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Solution2609 solution = new Solution2609();
        String s = "01011";
        System.out.println(solution.findTheLongestBalancedSubstring(s));
    }
}

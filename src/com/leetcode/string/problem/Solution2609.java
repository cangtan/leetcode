package com.leetcode.string.problem;

/**
 * 最长平衡子字符串
 */
public class Solution2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int max = 0;
        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (one > 0) {
                    int temp = Math.min(zero, one) * 2;
                    max = Math.max(max, temp);
                    zero = 0;
                    one = 0;
                }
                zero++;
            } else if (s.charAt(i) == '1') {
                one++;
            }
        }
        if (one > 0 ){
            int temp = Math.min(zero, one) * 2;
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2609 solution = new Solution2609();
        String str = "01000111";
        System.out.println(solution.findTheLongestBalancedSubstring(str));
    }
}

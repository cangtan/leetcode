package com.leetcode.other.problem;

/**
 * 连续字符
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-12-01 14:34:00
 * @see <a href="https://leetcode.cn/problems/consecutive-characters/">连续字符</a>
 */
public class Solution1446 {
    public int maxPower(String s) {
        int result = 1;
        int temp = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                temp++;
                result = Math.max(result, temp);
            } else {
                temp = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1446 solution = new Solution1446();
        String s = "hooraaaaaaaaaaay";
        System.out.println(solution.maxPower(s));
    }
}

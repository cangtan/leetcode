package com.leetcode.other.problem;

/**
 * 检查句子中的数字是否递增
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-03 16:58:00
 */
public class Solution2042 {

    public boolean areNumbersAscending(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int prefix = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                stringBuilder.append(chars[i]);
            } else if(stringBuilder.length() > 0) {
                int anInt = Integer.parseInt(stringBuilder.toString());
                if (anInt <= prefix) {
                    return false;
                } else {
                    prefix = anInt;
                }
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        if (stringBuilder.length() > 0) {
            int anInt = Integer.parseInt(stringBuilder.toString());
            return anInt > prefix;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2042 solution = new Solution2042();
        String s = "4 5 11 26";
        System.out.println(solution.areNumbersAscending(s));
    }
}

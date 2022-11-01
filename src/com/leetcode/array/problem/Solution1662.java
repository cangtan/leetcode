package com.leetcode.array.problem;

/**
 * 检查两个字符串数组是否相等
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/">1662. 检查两个字符串数组是否相等</a>
 * @since 2022-11-01 11:34:00
 */
public class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0;
        int j = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        int length1 = word1.length;
        int length2 = word2.length;
        while (i < length1 && j < length2) {
            char[] chars1 = word1[i].toCharArray();
            char[] chars2 = word2[j].toCharArray();
            while (pointer1 < chars1.length && pointer2 < chars2.length) {
                if (chars1[pointer1++] != chars2[pointer2++]) {
                    return false;
                }
            }
            if (pointer1 == chars1.length) {
                pointer1 = 0;
                i++;
            }
            if (pointer2 == chars2.length) {
                pointer2 = 0;
                j++;
            }
        }
        return i == length1 && j == length2;
    }


//    /**
//     * 拼接后进行比较
//     * @param args
//     */
//    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String s : word1) {
//            stringBuilder.append(s);
//        }
//        int i = 0;
//        for (String s : word2) {
//            char[] chars = s.toCharArray();
//            for (char aChar : chars) {
//                if (i >= stringBuilder.length() || stringBuilder.charAt(i++) != aChar) {
//                    return false;
//                }
//            }
//        }
//        if (stringBuilder.length() != i) {
//            return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        String[] word1 = {"abcd", "edef", "e"};
        String[] word2 = {"abcdedef", "e"};
        Solution1662 solution = new Solution1662();
        System.out.println(solution.arrayStringsAreEqual(word1, word2));
    }
}

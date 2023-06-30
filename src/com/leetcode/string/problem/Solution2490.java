package com.leetcode.string.problem;

/**
 * 回环局
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-30 10:59:00
 */
public class Solution2490 {
    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");
        if (strs[0].charAt(0) != strs[strs.length - 1].charAt(strs[strs.length - 1].length() - 1)) {
            return false;
        }
        for (int i = 1; i < strs.length; i++) {
            if (strs[i - 1].charAt(strs[i - 1].length() - 1) != strs[i].charAt(0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @author 力扣官方题解
     * @see <a href="https://leetcode.cn/problems/circular-sentence/solution/hui-huan-ju-by-leetcode-solution-h853/">力扣官方题解</a>
     */
    public boolean isCircularSentence2(String sentence) {
        if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i + 1) != sentence.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2490 solution = new Solution2490();
        String sentence = "Leetcode is cool";
        System.out.println(solution.isCircularSentence(sentence));
    }
}

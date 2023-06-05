package com.leetcode.string.problem;

/**
 * 771. 宝石与石头
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-05 17:23:00
 */
public class Solution771 {
    public int numJewelsInStones(String jewels, String stones) {
        char[] jewelArr = jewels.toCharArray();
        char[] stoneArr = stones.toCharArray();
        boolean[] bucket = new boolean[52];
        for (char c : jewelArr) {
            if (c >= 'A' && c <= 'Z') {
                int index = c - 'A' + 26;
                bucket[index] = true;
            } else {
                int index = c - 'a';
                bucket[index] = true;
            }
        }
        int result = 0;
        for (char c : stoneArr) {
            int index;
            if (c >= 'A' && c <= 'Z') {
                index = c - 'A' + 26;
            } else {
                index = c - 'a';
            }
            if (bucket[index]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution771 solution = new Solution771();
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(solution.numJewelsInStones(jewels, stones));
    }
}

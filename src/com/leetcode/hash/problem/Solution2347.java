package com.leetcode.hash.problem;

/**
 * 最好的扑克手牌
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-20 11:09:00
 */
public class Solution2347 {
    public String bestHand(int[] ranks, char[] suits) {
        int[] suitBucket = new int[4];
        int[] ranksBucket = new int[14];
        int length = suits.length;
        for (int i = 0; i < length; i++) {
            suitBucket[suits[i] - 'a']++;
            ranksBucket[ranks[i]]++;
        }
        for (int i : suitBucket) {
            if (i >= 5) {
                return "Flush";
            }
        }
        String result = "High Card";
        for (int i : ranksBucket) {
            if (i >= 3) {
                return "Three of a Kind";
            } else if (i == 2) {
                result = "Pair";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2347 solution = new Solution2347();
        int[] ranks = {};
        char[] suits = {};
        System.out.println(solution.bestHand(ranks, suits));
    }
}

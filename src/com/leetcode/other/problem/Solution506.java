package com.leetcode.other.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 相对名次
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-12-02 13:58:00
 * @see <a href="https://leetcode-cn.com/problems/relative-ranks/">相对名次</a>
 */
public class Solution506 {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        int rank = 1;
        String[] str = new String[score.length];
        for (int i = score.length - 1; i >= 0; i--) {
            int index = map.get(score[i]);
            if (rank == 1) {
                str[index] = "Gold Medal";
            } else if (rank == 2) {
                str[index] = "Silver Medal";
            } else if (rank == 3) {
                str[index] = "Bronze Medal";
            } else {
                str[index] = rank + "";
            }
            rank++;
        }
        return str;
    }

    public static void main(String[] args) {
        Solution506 solution = new Solution506();
        int[] score = {10, 3, 8, 9, 4};
        for (String relativeRank : solution.findRelativeRanks(score)) {
            System.out.print(relativeRank + " ");
        }
        System.out.println();
    }
}

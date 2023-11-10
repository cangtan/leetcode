package com.leetcode.other.problem;

import java.util.Arrays;

/**
 * 咒语与药水的成功对数
 */
public class Solution2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        int n = potions.length;
        for (int i = 0; i < spells.length; i++) {
            double v = success / (double) spells[i];
            long point = (long) Math.ceil(v);
            int index = binarySearch(potions, point);
            result[i] = n - index;
        }
        return result;
    }

    int binarySearch(int[] potions, long target) {
        int left = 0;
        int right = potions.length - 1;
        int res = potions.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (potions[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2300 solution = new Solution2300();
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        long success = 16;
        int[] result = solution.successfulPairs(spells, potions, success);
        Arrays.stream(result).forEach(System.out::println);
    }

}

package com.leetcode.array.problem;

import java.util.Arrays;

/**
 * 数组能形成多少对数对
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-16 09:25:00
 */
public class Solution2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] bucket = new int[101];
        for (int num : nums) {
            bucket[num]++;
        }
        int pair = 0;
        int remain = 0;
        for (int i : bucket) {
            pair += i / 2;
            remain += i % 2;
        }
        return new int[]{pair, remain};
    }

    public static void main(String[] args) {
        Solution2341 solution = new Solution2341();
        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        int[] ints = solution.numberOfPairs(nums);
        Arrays.stream(ints).forEach(System.out::println);
    }
}

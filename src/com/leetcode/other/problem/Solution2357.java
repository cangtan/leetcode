package com.leetcode.other.problem;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 使数组中所有元素都等于零
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-24 11:38:00
 */
public class Solution2357 {
    public int minimumOperations(int[] nums) {
        boolean[] flag = new boolean[101];
        int times = 0;
        for (int num : nums) {
            if (num !=0 && !flag[num]) {
                flag[num] = true;
                times++;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        Solution2357 solution = new Solution2357();
        int[] nums = {0};
        System.out.println(solution.minimumOperations(nums));
    }
}

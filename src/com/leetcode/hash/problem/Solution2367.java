package com.leetcode.hash.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 算术三元的数目
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-03-31 09:27:00
 */
public class Solution2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (set.contains(num+diff) && set.contains(num+2*diff)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

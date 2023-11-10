package com.leetcode.hash.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数组中好对子的数目
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-18 09:25:00
 */
public class Solution1814 {
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) => nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        int res = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            int temp = num;
            int j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp = temp / 10;
            }
            int fn = num - j;
            res = (res + hash.getOrDefault(fn, 0)) % mod;
            hash.put(fn, hash.getOrDefault(fn, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1814 solution = new Solution1814();
        int[] nums = {42,11,1,97};
        System.out.println(solution.countNicePairs(nums));
    }
}

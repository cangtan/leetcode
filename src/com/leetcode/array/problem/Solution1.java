package com.leetcode.array.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-18 10:54:00
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        // 哈希表
        Map<Integer, Integer> hash = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                result[0] = hash.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                hash.put(target - nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Arrays.stream(solution.twoSum(nums, target)).forEach(System.out::println);
    }
}

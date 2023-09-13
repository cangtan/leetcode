package com.leetcode.bitwise.problem;

/**
 * 只出现一次的数字
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-09-12 14:38:00
 */
public class Solution136 {
    /**
     * 异或运算有以下三个性质。
     * 任何数和 0做异或运算，结果仍然是原来的数，即 a^0=a
     * 任何数和其自身做异或运算，结果是 0 即 a^a = 0
     * 异或运算满足交换律和结合律
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        Solution136 solution = new Solution136();
        int[] nums = {1, 3, 5, 7, 3, 5, 1};
        System.out.println(solution.singleNumber(nums));
    }
}

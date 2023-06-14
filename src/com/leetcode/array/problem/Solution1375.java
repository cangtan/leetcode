package com.leetcode.array.problem;

/**
 * 二进制字符串前缀一致的次数
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-14 15:29:00
 */
public class Solution1375 {
    public int numTimesAllBlue(int[] flips) {
        // 在第i次翻转之后，我们希望[1,i]内的所有位都是1，这等价于[前i次翻转中下标的最大值等于i]
        int max = 0;
        int result = 0;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(flips[i], max);
            if (i == max - 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1375 solution = new Solution1375();
        int[] flips = {3, 2, 4, 1, 5};
        System.out.println(solution.numTimesAllBlue(flips));
    }
}

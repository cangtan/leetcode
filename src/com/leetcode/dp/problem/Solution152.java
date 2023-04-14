package com.leetcode.dp.problem;

/**
 * 乘积最大子数组
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-14 09:23:00
 */
public class Solution152 {
    /**
     * 分正负性讨论
     * 正数我们希望以前一位结尾的某个段的积为尽可能大的正数
     * 负数我们希望以前一位结尾的某个段的积为尽可能小的负数
     * 状态转移方程如下
     * fmax(i) = Math[a0...an].max(fmax(i - 1) * ai, fmin(i - 1)* ai, ai)
     * fmin(i) = Math[a0...an].min(fmax(i - 1) * ai, fmin(i - 1)* ai, ai)
     */
    public int maxProduct(int[] nums) {

        int length = nums.length;
        int[] fmax = new int[length];
        int[] fmin = new int[length];
        fmax[0] = nums[0];
        fmin[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            fmax[i] = Math.max(fmax[i - 1] * nums[i], Math.max(nums[i], fmin[i - 1] * nums[i]));
            fmin[i] = Math.min(fmax[i - 1] * nums[i], Math.min(nums[i], fmin[i - 1] * nums[i]));
            result = Math.max(result, fmax[i]);
        }
        return result;
    }

    public int maxProductForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cache = nums[i];
            max = Math.max(cache, max);
            for (int j = i + 1; j < nums.length; j++) {
                cache *= nums[j];
                max = Math.max(cache, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution152 solution = new Solution152();
        int[] nums = {2, 3, -2, 4};
        // 2, 3, -2, 4, 3 [2,6,-12,4,12]
        // 2, 3, -2, 4, -3 [2,6, -12, -48, 144]
        // 2, 3, -2, 4, -3, -1, 10 [2,6, -12, -48, 144, -144, -1440]
        // 以2结尾的数组 => max = 2
        // 以3结尾的数组 => max = 6
        // 以-2结尾的数组 => 6 * -2, 6 => max = 6
        // 以-3 结尾 只有出现负数的时候 1.前面是否有负数
        System.out.println(solution.maxProduct(nums));
    }
}

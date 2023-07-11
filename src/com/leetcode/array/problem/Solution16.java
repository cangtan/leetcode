package com.leetcode.array.problem;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-10 17:53:00
 */
public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int temp = Math.abs(target - sum);
                if (temp < diff) {
                    diff = temp;
                    result = sum;
                }
                if (sum >= target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums, target));
    }
}

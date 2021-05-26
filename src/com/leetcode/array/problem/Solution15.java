package com.leetcode.array.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3sum
 *
 * @author 薛佳豪
 * @version V1.0
 * @date 2021-3-1 17:15
 * @link https://leetcode-cn.com/problems/3sum/
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 排序后使用双指针遍历, a + b + c = 0 -> a + b = -c
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums [left] < -nums[right]) {
                    left++;
                } else if (nums[i] + nums [left] > -nums[right]) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        Solution15 solution15 = new Solution15();
        solution15.threeSum(nums).forEach(item -> System.out.print(item + " "));
    }
}

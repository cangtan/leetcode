package com.leetcode.array.problem;

/**
 * @version V1.0
 * @Description: Move Zeroes
 * @author: ives
 * @date: 2021-3-1 16:40
 * @link: https://leetcode.com/problems/move-zeroes/
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution283 solution = new Solution283();
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

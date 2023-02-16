package com.leetcode.stack.problem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大宽度坡
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-14 17:22:00
 */
public class Solution962 {

    /**
     * 最简单的情况即最左端的i=0,最右端的j=n-1 那么宽度就是 n - 1 - i
     * 所以我们想知道右边下一个更大元素是否还小于等于最右边的那个A[j] 如果不满足了，那么坡度也停止延展了
     */
    public int maxWidthRamp(int[] nums) {
        // 单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int result = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                Integer i = stack.pop();
                result = Math.max(result, j - i);
            }
        }
        return result;
    }

//    public int maxWidthRamp(int[] nums) {
//        // 暴力起手,超时
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = nums.length - 1; j > i; j--) {
//                if (nums[i] <= nums[j]) {
//                    result = Math.max(result, j - i);
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution962 solution = new Solution962();
        int[] nums = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println(solution.maxWidthRamp(nums));
    }
}

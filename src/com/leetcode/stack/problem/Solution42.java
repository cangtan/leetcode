package com.leetcode.stack.problem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-11-18 16:45:00
 */
public class Solution42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int top;
        int left;
        int result = 0;
        // 记录上一个点和上上一个点为top与left
        // 则 min(current, left) * (i - left - 1)
        for (int i = 0; i < height.length; i++) {
            // 查看前一位是否小于自己
            if (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                top = stack.pop();
                while (!stack.isEmpty()) {
                    if (height[stack.peek()] <= height[i]) {
                        left = stack.pop();
                        result += (height[left] - height[top]) * (i - left - 1);
                        top = left;
                    } else {
                        left = stack.peek();
                        result += (height[i] - height[top]) * (i - left - 1);
                        break;
                    }
                }
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution42.trap(height));
    }
}

package com.leetcode.stack.problem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-12-01 15:59:00
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        // 根据暴力方法演变
        // 利用单调栈进行了数据存储
        Deque<Integer> stack = new ArrayDeque<>();
        int[] lefts = new int[heights.length];
        int[] rights = new int[heights.length];
        // 寻找左边界
        for (int i = 0; i < heights.length; i++) {
            // 寻找栈中小于自己的值
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            lefts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            // 寻找栈中小于自己的值
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rights[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, (rights[i] - lefts[i] - 1) * heights[i]);
        }
        return result;
    }

    /**
     * 暴力解法（我暴力解法的思路不对啊）
     */
    public int largestRectangleAreaLoop(int[] heights) {
        // 暴力解法 超出时间限制
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j >= 0; j--) {
                min = Math.min(heights[j], min);
                result = Math.max(result, (i - j + 1) * min);
            }
        }
        return result;
    }

    /**
     * 暴力解法
     * 官方的暴力解法
     * 固定高度,寻找左右两边小于自身的高度值计算面
     * 暴力解法的缺陷是没有为下一次计算记录下有用的值
     */
    public int largestRectangleAreaLoop2(int[] heights) {
        // 还是超出了时间限制
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }
            int area = (right - left + 1) * heights[i];
            result = Math.max(result, area);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution84 solution = new Solution84();
        int[] heights = {2, 1, 2};
        System.out.println(solution.largestRectangleArea(heights));
    }
}

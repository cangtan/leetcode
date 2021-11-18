package com.leetcode.stack.problem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-11-15 11:37:00
 * @link https://leetcode-cn.com/problems/daily-temperatures/
 */
public class Solution739 {
    /**
     * 使用栈的方法解决
     * 栈中存放元素下标
     * 我竟然一开始存了元素。。。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 当栈顶元素比当前元素小则取出并计数 + 1;
            while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i]) {
                Integer idx = deque.pop();
                result[idx] = i - idx;
            }
            deque.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        int[] array = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] result = solution739.dailyTemperatures(array);
        for (int n : result) {
            System.out.println(n);
        }
    }

    /**
     * 数组的方式
     * 实际上和栈是一样的
     *
     * @author Luckman
     * @link https://leetcode.com/problems/daily-temperatures/discuss/109832/Java-Easy-AC-Solution-with-Stack
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }
}

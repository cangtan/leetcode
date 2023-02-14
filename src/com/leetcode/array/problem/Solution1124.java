package com.leetcode.array.problem;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 表现良好的最长时间段
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/longest-well-performing-interval/">1124. 表现良好的最长时间段</a>
 * @since 2023-02-14 09:15:00
 */
public class Solution1124 {
    /**
     * 前缀和+单调栈
     * 以输入样例 hours = [9,9,6,0,6,6,9]为例,将大于8小时的一天记为1，小于等于8小时的一天记为-1
     * 计算前缀和得到presum = [0,1,2,1,0,-1,-2,-1]
     * 即求j - i 最大的值 保证 presum[j] - presum[i] > 0
     * 维护一个单调栈，存储presum的索引，栈中索引指向严格单调递减
     * 从后往前遍历宿主，与栈顶比较，相减结果 > 0 则出栈，直到不大于0位置, 然后更新最大宽度
     * 同类型题<a href="https://leetcode.cn/problems/maximum-width-ramp/n/">最大宽度坡</a>
     */
//    public int longestWPI(int[] hours) {
//        int result = 0;
//        int[] presum = new int[hours.length + 1];
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(0);
//        for (int i = 1; i <= hours.length; i++) {
//            presum[i] = presum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
//            if (presum[stack.peek()] > presum[i]) {
//                stack.push(i);
//            }
//        }
//        for (int r = hours.length; r > 0; r--) {
//            while (!stack.isEmpty() && presum[r] - presum[stack.peek()] > 0) {
//                result = Math.max(result, r - stack.pop());
//            }
//        }
//        return result;
//    }

    /**
     * 前缀和 + hash
     * 对于某个下标i(从0开始)，找到最小的j(j < i), 满足s[j] < s[i]
     * 根据情况判断s[i]是否大于0进行讨论
     * s[i] > 0,那么前i+1项元素之和大于0,表示有一个长度为i+1的大于0的区间
     * s[i] < 0,我们在前面视图寻找一个下标j, 满足s[j] = s[i] - 1,如果有,则表示区间[j+1,i]是我们要找的以i结尾的最长区间
     */
//    public int longestWPI(int[] hours) {
//        int result = 0;
//        Map<Integer, Integer> hash = new HashMap<>();
//        int presum = 0;
//        for (int i = 0; i < hours.length; i++) {
//            // 计算前缀和
//            presum += hours[i] > 8 ? 1 : -1;
//            if (presum > 0) {
//                result = Math.max(result, i + 1);
//            } else {
//                if (hash.containsKey(presum - 1)) {
//                    result = Math.max(i - hash.get(presum - 1), result);
//                }
//            }
//            if (!hash.containsKey(presum)) {
//                hash.put(presum, i);
//            }
//        }
//        return result;
//    }

    /**
     * 基于上面hash的思想,将hash表缓存数组以提升时间, 但数组可能存在负数的情况
     * 而我们仅需要讨论[-n, 0]的情况，因此将前缀和进行取反
     */
    public int longestWPI(int[] hours) {
        int result = 0;
        int[] hash = new int[hours.length + 2];
        int presum = 0;
        for (int i = 1; i <= hours.length; i++) {
            // 计算前缀和
            presum -= hours[i - 1] > 8 ? 1 : -1;
            if (presum < 0) {
                result = i;
            } else {
                if (hash[presum + 1] > 0) {
                    // s[i] - 1 存在下标
                    result = Math.max(result, i - hash[presum + 1]);
                }
                if (hash[presum] == 0) {
                    hash[presum] = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1124 solution = new Solution1124();
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        System.out.println(solution.longestWPI(hours));
    }
}

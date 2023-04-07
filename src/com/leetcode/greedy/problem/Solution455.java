package com.leetcode.greedy.problem;

import java.util.Arrays;

/**
 * 分发饼干
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-07 14:46:00
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        // 排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 尺寸索引
        int index = 0;
        // s >= g
        // 当g>s时，要移动的是s,要保持s>=g的状态。
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && g[index] <= s[i]) {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution455 solution = new Solution455();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(solution.findContentChildren(g, s));
    }
}

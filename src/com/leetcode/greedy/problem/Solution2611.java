package com.leetcode.greedy.problem;

import java.util.Arrays;

/**
 * 老鼠和奶酪
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-07 16:07:00
 */
public class Solution2611 {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[] diff = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k; i++) {
            ans += diff[n - 1 - i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2611 solution = new Solution2611();
        int[] reward1 = {1, 1, 3, 4};
        int[] reward2 = {4, 4, 1, 1};
        int k = 2;
        System.out.println(solution.miceAndCheese(reward1, reward2, k));
    }
}

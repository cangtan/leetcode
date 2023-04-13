package com.leetcode.dp.problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-12 11:33:00
 */
public class Solution120 {
    /**
     * 从底向上递推
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> node = triangle.get(i);
            for (int j = 0; j < node.size(); j++) {
                if (i == triangle.size() - 1) {
                    dp[j] = node.get(j);
                } else {
                    dp[j] = node.get(j) + Math.min(dp[j], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }

//    public int minimumTotal(List<List<Integer>> triangle) {
//        return minimumTotalHelper(triangle, 1, 0, 1) + triangle.get(0).get(0);
//    }
//
//    public int minimumTotalHelper(List<List<Integer>> triangle, int line, int left, int right) {
//        if (line >= triangle.size()) {
//            return 0;
//        }
//        List<Integer> node = triangle.get(line);
//        int leftResult = node.get(left) + minimumTotalHelper(triangle, line + 1, left, left + 1);
//        int rightResult = node.get(right) + minimumTotalHelper(triangle, line + 1, right, right + 1);
//        return Math.min(leftResult, rightResult);
//    }

    public static void main(String[] args) {
        Solution120 solution = new Solution120();
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        System.out.println(solution.minimumTotal(triangle));
    }
}

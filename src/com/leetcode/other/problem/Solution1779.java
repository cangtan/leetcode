package com.leetcode.other.problem;

/**
 * 找到最近的有相同X或Y坐标的点
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-12-01 09:12:00
 */
public class Solution1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int dist = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if (minIndex == -1 || dist < minValue) {
                    minIndex = i;
                    minValue = dist;
                }
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Solution1779 solution = new Solution1779();
        int x = 3;
        int y = 4;
        int[][] points = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        System.out.println(solution.nearestValidPoint(x, y, points));
    }
}

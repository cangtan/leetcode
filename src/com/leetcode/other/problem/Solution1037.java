package com.leetcode.other.problem;

/**
 * 有效的回旋镖
 *
 * @author cangtan
 * @version V1.0
 * @date 2022-06-08 10:04:00
 * @see <a href="https://leetcode.cn/problems/valid-boomerang/"></a>
 */
public class Solution1037 {
    public boolean isBoomerang(int[][] points) {
        int line1 = (points[1][0] - points[0][0]) * (points[2][1] - points[1][1]);
        int line2 = (points[2][0] - points[1][0]) * (points[1][1] - points[0][1]);
        return line1 != line2;
    }

    public static void main(String[] args) {
        Solution1037 solution = new Solution1037();
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(solution.isBoomerang(points));
    }
}

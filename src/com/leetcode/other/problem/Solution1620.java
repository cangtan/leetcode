package com.leetcode.other.problem;

import java.util.Arrays;

/**
 * 网络信号最好的坐标
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/coordinate-with-maximum-network-quality/comments/">网络信号最好的坐标</a>
 * @since 2022-11-03 18:47:00
 */
public class Solution1620 {

    /**
     * 找出所有坐标并归类, 遍历归类求信号最大值
     */
    public int[] bestCoordinate(int[][]  towers, int radius) {
        int[] result = new int[2];
        int max = 0;
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int power = 0;
                for (int[] tower : towers) {
                    double sqrt = Math.sqrt(Math.pow((tower[0] - x), 2) + Math.pow((tower[1] - y), 2));
                    if (sqrt <= radius) {
                        power += (int)(tower[2] / (1 + sqrt));
                    }
                }
                if (power > max) {
                    max = power;
                    result[0] = x;
                    result[1] = y;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] towers = {{50, 20, 31}, {43,36,29}};
        int radius = 38;
        Solution1620 solution = new Solution1620();
        int[] ints = solution.bestCoordinate(towers, radius);
        Arrays.stream(ints).forEach(System.out::println);
    }
}

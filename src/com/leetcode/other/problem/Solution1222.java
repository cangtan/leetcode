package com.leetcode.other.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 可以攻击国王的皇后
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-09-14 13:51:00
 */
public class Solution1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new LinkedList<>();
        int y = king[0];
        int x = king[1];
        int c = y - x;
        int d = y + x;
        List<List<Integer>> temp = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            List<Integer> list = new ArrayList<>(2);
            temp.add(list);
        }
        for (int[] queen : queens) {
            int v = queen[0] - queen[1];
            int w = queen[0] + queen[1];
            if (queen[0] == king[0] || queen[1] == king[1] || v == c || w == d) {
                if (queen[0] < king[0] && queen[1] < king[1]) {
                    update(0, king, temp, queen);
                } else if (queen[0] < king[0] && queen[1] > king[1]) {
                    update(1, king, temp, queen);
                } else if (queen[0] > king[0] && queen[1] < king[1]) {
                    update(2, king, temp, queen);
                } else if (queen[0] > king[0] && queen[1] > king[1]) {
                    update(3, king, temp, queen);
                } else if (queen[0] == king[0] && queen[1] > king[1]) {
                    update(4, king, temp, queen);
                } else if (queen[0] == king[0] && queen[1] < king[1]) {
                    update(5, king, temp, queen);
                } else if (queen[0] > king[0]) {
                    update(6, king, temp, queen);
                } else if (queen[0] < king[0]) {
                    update(7, king, temp, queen);
                }
            }
        }
        for (List<Integer> integers : temp) {
            if (!integers.isEmpty()) {
                result.add(integers);
            }
        }
        return result;
    }

    private static void update(int i, int[] king, List<List<Integer>> temp, int[] queen) {
        if (temp.get(i).isEmpty()) {
            temp.get(i).add(queen[0]);
            temp.get(i).add(queen[1]);
        } else {
            int y2 = temp.get(i).get(0) - king[0];
            int x2 = temp.get(i).get(1) - king[1];
            int y1 = queen[0] - king[0];
            int x1 = queen[1] - king[1];
            if (Math.sqrt((double) y1 * y1 + x1 * x1) < Math.sqrt((double) y2 * y2 + x2 * x2)) {
                temp.get(i).set(0, queen[0]);
                temp.get(i).set(1, queen[1]);
            }
        }
    }

    public static void main(String[] args) {
        Solution1222 solution = new Solution1222();
        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = {0, 0};
        System.out.println(solution.queensAttacktheKing(queens, king));
    }
}

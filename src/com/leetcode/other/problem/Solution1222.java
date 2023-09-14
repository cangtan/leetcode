package com.leetcode.other.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 可以攻击国王的皇后
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-09-14 13:51:00
 */
public class Solution1222 {
    /**
     * 从国王出发
     * 作者：力扣官方题解
     * 链接：<a href="https://leetcode.cn/problems/queens-that-can-attack-the-king/">力扣官方题解</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<List<Integer>> queensAttacktheKing1(int[][] queens, int[] king) {
        Set<Integer> queenPos = new HashSet<Integer>();
        for (int[] queen : queens) {
            int x = queen[0], y = queen[1];
            queenPos.add(x * 8 + y);
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dy = -1; dy <= 1; ++dy) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                int kx = king[0] + dx, ky = king[1] + dy;
                while (kx >= 0 && kx < 8 && ky >= 0 && ky < 8) {
                    int pos = kx * 8 + ky;
                    if (queenPos.contains(pos)) {
                        List<Integer> posList = new ArrayList<Integer>();
                        posList.add(kx);
                        posList.add(ky);
                        ans.add(posList);
                        break;
                    }
                    kx += dx;
                    ky += dy;
                }
            }
        }
        return ans;
    }

    /**
     * 从皇后出发
     * 作者：力扣官方题解
     * 链接：<a href="https://leetcode.cn/problems/queens-that-can-attack-the-king/">...</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<List<Integer>> queensAttacktheKing2(int[][] queens, int[] king) {
        Map<Integer, int[]> candidates = new HashMap<Integer, int[]>();
        int kx = king[0], ky = king[1];
        for (int[] queen : queens) {
            int qx = queen[0], qy = queen[1];
            int x = qx - kx, y = qy - ky;
            if (x == 0 || y == 0 || Math.abs(x) == Math.abs(y)) {
                int dx = sgn(x), dy = sgn(y);
                int key = dx * 10 + dy;
                if (!candidates.containsKey(key) || candidates.get(key)[2] > Math.abs(x) + Math.abs(y)) {
                    candidates.put(key, new int[]{queen[0], queen[1], Math.abs(x) + Math.abs(y)});
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, int[]> entry : candidates.entrySet()) {
            int[] value = entry.getValue();
            List<Integer> posList = new ArrayList<Integer>();
            posList.add(value[0]);
            posList.add(value[1]);
            ans.add(posList);
        }
        return ans;
    }

    public int sgn(int x) {
        return x > 0 ? 1 : (x == 0 ? 0 : -1);
    }


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

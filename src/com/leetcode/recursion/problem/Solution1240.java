package com.leetcode.recursion.problem;

/**
 * 铺瓷砖
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-08 10:57:00
 */
public class Solution1240 {
    int ans;

    public int tilingRectangle(int n, int m) {
        ans = Math.max(n, m);
        boolean[][] rect = new boolean[n][m];
        dfs(0, 0, rect, 0);
        return ans;
    }

    public void dfs(int x, int y, boolean[][] rect, int cnt) {
        int n = rect.length;
        int m = rect[0].length;
        if (cnt >= ans) {
            return;
        }
        if (x >= n) {
            ans = cnt;
            return;
        }
        // 检测下一行
        if (y >= m) {
            dfs(x + 1, 0, rect, cnt);
            return;
        }
        // 如果当前已经被覆盖，则直接尝试下一个位置
        if (rect[x][y]) {
            dfs(x, y + 1, rect, cnt);
            return;
        }
        for (int k = Math.min(n - x, m - y); k >= 1 && isAvailable(rect, x, y, k); k--) {
            // 将长度为k的正方形区域标记覆盖
            fillUp(rect, x, y, k, true);
            // 跳过k个位置开始检测
            dfs(x, y + k, rect, cnt + 1);
            fillUp(rect, x, y, k, false);
        }
    }

    public boolean isAvailable(boolean[][] rect, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[x + 1][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void fillUp(boolean[][] rect, int x, int y, int k, boolean val) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[x + i][y + j] = val;
            }
        }
    }

    public static void main(String[] args) {
        Solution1240 solution = new Solution1240();
        int n = 0;
        int m = 0;
        System.out.println(solution.tilingRectangle(n, m));
    }
}

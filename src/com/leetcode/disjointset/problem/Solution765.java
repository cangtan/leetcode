package com.leetcode.disjointset.problem;

/**
 * 765. 情侣牵手
 */
public class Solution765 {
    /**
     * 最少次数 = 坐错对的情侣次数 - 1
     * 至少交换的次数 = 所有情侣的对数 - 并查集里连通分量的个数
     */
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < row.length; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - unionFind.getCount();
    }

    static class UnionFind {
        private int[] parent;
        /**
         * 连通风量
         */
        private int count;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            parent[px] = py;
            count--;
        }
    }

    public static void main(String[] args) {
        Solution765 solution = new Solution765();
        int[] row = {0, 2, 1, 3};
        System.out.println(solution.minSwapsCouples(row));
    }
}

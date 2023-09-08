package com.leetcode.tree.problem;


/**
 * 树节点的第K个祖先
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-12 10:45:00
 */
public class Solution1483 {
    /**
     * 最暴力的做法是一步步地往上跳，即 node -> parent[node] -> parent[parent[node]] -> ...
     * 需要跳k次才能到达node第k个祖先
     * 采用倍增的思想优化这个步骤，每次可以跳2^j步,即预处理出每个节点的[爷爷]节点,即父节点的父节点，那么就可以两步两步地往上跳，从而减少一半的跳跃次数
     * 预处理出每个节点的2^i个祖先节点，由于任意k可以分解为若干不同的2的幂（如k=13=8+4+1=1101(2)），预先处理后可以快速达到任意第k个祖先节点
     */
    static class TreeAncestor {

        int[][] dp;

        public TreeAncestor(int n, int[] parent) {
            int m = 32 - Integer.numberOfLeadingZeros(n);
            dp = new int[n][m];
            for (int i = 0; i < parent.length; i++) {
                dp[i][0] = parent[i];
            }
            for (int j = 0; j < m - 1; j++) {
                for (int i = 0; i < n; i++) {
                    int p = dp[i][j];
                    dp[i][j + 1] = p < 0 ? -1 : dp[p][j];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            int m = 32 - Integer.numberOfLeadingZeros(k);
            for (int i = 0; i < m; i++) {
                if (((k >> i) & 1) == 1) {
                    node = dp[node][i];
                    if(node == -1) {
                        break;
                    }
                }
            }
            return node;
        }
    }

    public static void main(String[] args) {
        Solution1483 solution1483 = new Solution1483();
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }
}

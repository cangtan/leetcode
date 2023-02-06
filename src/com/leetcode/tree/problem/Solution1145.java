package com.leetcode.tree.problem;

import com.leetcode.tree.TreeNode;

/**
 * 二叉树着色游戏
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-03 09:26:00
 */
public class Solution1145 {

    TreeNode target = null;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        int top = dfs(root, x);
        int left = dfs(target.left, x);
        int right = dfs(target.right, x);
        int mid = (n + 1) / 2;
        return top >= mid || left >= mid || right >= mid;
    }

    public int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        if (root.val == x) {
            target = root;
            return 0;
        }
        return dfs(root.left, x) + dfs(root.right, x) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(6);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(8);
//        TreeNode node8 = new TreeNode(9);
//        TreeNode node9 = new TreeNode(10);
//        TreeNode node10 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        node3.left = node7;
//        node3.right = node8;
//        node4.left = node9;
//        node4.right = node10;

        Solution1145 solution = new Solution1145();
        System.out.println(solution.btreeGameWinningMove(root, 3, 1));
    }
}

package com.leetcode.tree.problem;

import com.leetcode.tree.TreeNode;

/**
 * 在二叉树中分配硬币
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-14 10:23:00
 */
public class Solution979 {
    int move = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }

    /**
     * 以SUM(a)表示以节点a为根节点的子树中含有的二叉树节点的值之和，此时可以知道dfs(a) = sum(a)-count(a)
     * 子树中的金币数量大于节点的总数量，此时需要向a的父节点移动sum(a)-count(a)金币
     * 子树中的金币数量小于节点的总数量，此时需要从a的父节点移动count(a)-sum(a)金币
     * 相等则不需要移动
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int moveLeft = 0;
        int moveRight = 0;
        if (root.left != null) {
            moveLeft = dfs(root.left);
        }
        if (root.right != null) {
            moveRight = dfs(root.right);
        }
        move += Math.abs(moveLeft) + Math.abs(moveRight);
        // -1 (本身需要保留一个金币
        return moveLeft + moveRight + root.val - 1;
    }

    public static void main(String[] args) {
        Solution979 solution = new Solution979();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(solution.distributeCoins(root));
    }
}

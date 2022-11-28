package com.leetcode.recursion.problem;

import com.leetcode.tree.TreeNode;

/**
 * 翻转二叉树
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-28 15:57:00
 * @see <a href="https://leetcode.cn/problems/invert-binary-tree/">翻转二叉树</a>
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public static void main(String[] args) {
        Solution226 solution = new Solution226();
        TreeNode leftSon1 = new TreeNode(1);
        TreeNode leftSon2 = new TreeNode(3);
        TreeNode left = new TreeNode(2, leftSon1, leftSon2);
        TreeNode rightSon1 = new TreeNode(6);
        TreeNode rightSon2 = new TreeNode(9);
        TreeNode right = new TreeNode(7, rightSon1, rightSon2);
        TreeNode root = new TreeNode(4, left, right);
        TreeNode treeNode = solution.invertTree(root);
        TreeNode.preorderTraversal(treeNode);
    }
}

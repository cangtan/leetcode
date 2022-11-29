package com.leetcode.recursion.problem;

import com.leetcode.tree.TreeNode;

/**
 * 二叉树的最大深度
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-28 20:00:00
 * @see <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">二叉树的最大深度</a>
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Solution104 solution = new Solution104();
        TreeNode left = new TreeNode(9);
        TreeNode rightChild1 = new TreeNode(15);
        TreeNode rightChild2 = new TreeNode(7);
        TreeNode right = new TreeNode(20, rightChild1, rightChild2);
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(solution.maxDepth(root));
    }
}

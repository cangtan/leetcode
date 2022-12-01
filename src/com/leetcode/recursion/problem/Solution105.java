package com.leetcode.recursion.problem;

import com.leetcode.tree.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-12-01 17:01:00
 * @see <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">从前序与中序遍历序列构造二叉树</a>
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart <= preEnd) {
            TreeNode root = new TreeNode(preorder[preStart]);
            int i = inStart;
            while (i <= inEnd) {
                if (inorder[i] == preorder[preStart]) {
                    root.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + i - inStart, inStart, i);
                    break;
                }
                i++;
            }
            root.right = buildTreeHelper(preorder, inorder, preStart + i - inStart  + 1, preEnd, i + 1, inEnd);
            return root;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution105 solution = new Solution105();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = solution.buildTree(preorder, inorder);
        TreeNode.preorderTraversal(root);
    }
}

package com.leetcode.tree;

import java.util.Objects;

/**
 * TreeNode
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-28 15:58:00
 */
public class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static void preorderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
            preorderTraversal(treeNode.left);
            preorderTraversal(treeNode.right);
        }
    }

    public static void inorderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            preorderTraversal(treeNode.left);
            System.out.print(treeNode.val + " ");
            preorderTraversal(treeNode.right);
        }
    }

    public static void postorderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            preorderTraversal(treeNode.left);
            preorderTraversal(treeNode.right);
            System.out.print(treeNode.val + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode leftSon1 = new TreeNode(4);
        TreeNode leftSon2 = new TreeNode(5);
        TreeNode left = new TreeNode(1, leftSon1, leftSon2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, right);
        postorderTraversal(root);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}

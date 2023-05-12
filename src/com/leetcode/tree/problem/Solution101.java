package com.leetcode.tree.problem;

import com.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 对称二叉树
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-12 09:36:00
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        return cmp(root.left, root.right);
    }

    public boolean cmp(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return cmp(left.left, right.right) && cmp(left.right, right.left);
    }

    /**
     * 回文判断
     * 但写得好丑
     */
    public boolean isSymmetricUgly(TreeNode root) {
        List<Integer> left = new LinkedList<>();
        if (root.left != null) {
            left.add(root.left.val);
            countLeft(root.left, left);
        }
        List<Integer> right = new LinkedList<>();
        if (root.right != null) {
            countRight(root.right, right);
            right.add(root.right.val);
        }
        if (left.size() != right.size()) {
            return false;
        }
        int n = left.size();
        int i = 0;
        int j = n - 1;
        while (i < n && j > 0) {
            if (!left.get(i).equals(right.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void countLeft(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            result.add(root.left.val);
        } else {
            result.add(-101);
        }
        if (root.right != null) {
            result.add(root.right.val);
        } else {
            result.add(-101);
        }
        if (root.left != null) {
            countLeft(root.left, result);
        }
        if (root.right != null) {
            countLeft(root.right, result);
        }

    }

    public void countRight(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            countRight(root.left, result);
        }
        if (root.right != null) {
            countRight(root.right, result);
        }
        if (root.left != null) {
            result.add(root.left.val);
        } else {
            result.add(-101);
        }
        if (root.right != null) {
            result.add(root.right.val);
        } else {
            result.add(-101);
        }
    }

    public static void main(String[] args) {
        Solution101 solution = new Solution101();
        TreeNode root = test1();
        System.out.println(solution.isSymmetric(root));
    }

    public static TreeNode test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(7);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(5);
        return root;
    }
}

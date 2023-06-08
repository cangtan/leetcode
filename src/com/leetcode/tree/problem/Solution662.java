package com.leetcode.tree.problem;

import com.leetcode.tree.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 二叉树最大宽度
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-07 18:45:00
 */
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        LinkedList<Pair<TreeNode, Integer>> list = new LinkedList<>();
        list.add(new Pair<>(root, 1));
        while (!list.isEmpty()) {
            LinkedList<Pair<TreeNode, Integer>> temp = new LinkedList<>();
            for (Pair<TreeNode, Integer> poll : list) {
                TreeNode key = poll.getKey();
                if (key.left != null) {
                    temp.offer(new Pair<>(key.left, poll.getValue() * 2));
                }
                if (key.right != null) {
                    temp.offer(new Pair<>(key.right, poll.getValue() * 2 + 1));
                }
            }
            max = Math.max(max, list.get(list.size() - 1).getValue() - list.get(0).getValue() + 1);
            list = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        Solution662 solution = new Solution662();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println(solution.widthOfBinaryTree(root));
    }

    public static void test2() {
        Solution662 solution = new Solution662();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(7);
        System.out.println(solution.widthOfBinaryTree(root));
    }
}

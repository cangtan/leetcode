package com.leetcode.recursion.problem;

import com.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/">二叉树的序列化与反序列化</a>
 * @since 2022-11-30 09:24:00
 */
public class Solution297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "None";
        } else {
            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Deque<String> dataList = new LinkedList<>(Arrays.asList(split));
        return rdeserialize(dataList);
    }

    public TreeNode rdeserialize(Deque<String> dataList) {
        if ("None".equals(dataList.getFirst())) {
            dataList.pollFirst();
            return null;
        } else {
            String rootVal = dataList.pollFirst();
            TreeNode root = new TreeNode(Integer.parseInt(rootVal));
            root.left = rdeserialize(dataList);
            root.right = rdeserialize(dataList);
            return root;
        }
    }


    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode rightChild1 = new TreeNode(4);
        TreeNode rightChild2 = new TreeNode(5);
        TreeNode right = new TreeNode(3, rightChild1, rightChild2);
        TreeNode root = new TreeNode(1, left, right);
        Solution297 solution = new Solution297();
        String serialize = solution.serialize(root);
        TreeNode deserialize = solution.deserialize(serialize);
        TreeNode.preorderTraversal(deserialize);
    }
}

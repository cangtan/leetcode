package com.leetcode.tree.problem;

import com.leetcode.tree.TreeNode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 99. 恢复二叉搜索树
 * 如果“逆序对”为一对，则互换节点为该“逆序对"的两个成员
 * 若”你需对“为两对，则互换节点为第一对“逆序对”的首个节点喝第二个逆序对的第二个节点
 *
 * @author 薛佳豪
 * @version V1.0
 * @since 2023-09-08 16:24:00
 */
public class Solution99 {

    /**
     * 需要交换的节点a
     */
    TreeNode a;
    /**
     * 需要交换的节点b
     */
    TreeNode b;
    /**
     * 比较的上一节点
     */
    TreeNode last;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int val = b.val;
        b.val = a.val;
        a.val = val;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (last != null && last.val > root.val) {
            if (a == null) {
                // 首次出现逆序对
                a = last;
            }
            b = root;
        }
        last = root;
        inorder(root.right);
    }

    /**
     * 自己写的丑代码
     * 中序遍历排序, 然后转为数组找逆序对
     */
    public void recoverTree2(TreeNode root) {
        Map<Integer, TreeNode> map = new LinkedHashMap<>();
        inorder2(root, map);
        Integer[] arr = map.keySet().toArray(new Integer[0]);
        Integer aIndex = null;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (aIndex == null) {
                    aIndex = i;
                } else {
                    // 存在两对逆序对
                    TreeNode err1 = map.get(arr[aIndex]);
                    TreeNode err2 = map.get(arr[i + 1]);
                    int temp = err1.val;
                    err1.val = err2.val;
                    err2.val = temp;
                    aIndex = null;
                    break;
                }
            }
        }
        // 仅一对逆序对
        if (aIndex != null) {
            TreeNode err1 = map.get(arr[aIndex]);
            TreeNode err2 = map.get(arr[aIndex + 1]);
            int temp = err1.val;
            err1.val = err2.val;
            err2.val = temp;
        }
    }

    public void inorder2(TreeNode root, Map<Integer, TreeNode> map) {
        if (root == null) {
            return;
        }
        inorder2(root.left, map);
        map.put(root.val, root);
        inorder2(root.right, map);
    }

    public static void main(String[] args) {
        // [1,2,3,4,5,6]
        // [1,5,3,4,2,6] -> 只会出现一个
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        Solution99 solution = new Solution99();
        solution.recoverTree(root);
        TreeNode.inorderTraversal(root);
    }

}

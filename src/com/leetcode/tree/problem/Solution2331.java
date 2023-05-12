package com.leetcode.tree.problem;

import com.leetcode.tree.TreeNode;

/**
 * 计算布尔二叉树的值
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-06 09:21:00
 */
public class Solution2331 {
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 1) {
            return true;
        } else if (root.val == 0) {
            return false;
        } else if (root.val == 2) {
            return evaluateTree(root.left) && evaluateTree(root.right);
        } else if (root.val == 3) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        return false;
    }



    public static void main(String[] args) {

    }
}

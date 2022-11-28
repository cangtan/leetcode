package com.leetcode.recursion.problem;

import com.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 验证二叉搜索树
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-28 16:29:00
 * @see <a href="https://leetcode.cn/problems/validate-binary-search-tree/">验证二叉搜索树</a>
 */
public class Solution98 {

    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }


//    public boolean isValidBST(TreeNode root) {
//        // 中序遍历即升序排序，一时不知道怎么在遍历中比较，写得丑 V1
//        List<Integer> result = new LinkedList<>();
//        inorder(root, result);
//        for (int i = 0; i < result.size() - 1; i++) {
//            if (result.get(i) >= result.get(i + 1)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
    }

    public static void main(String[] args) {
        Solution98 solution = new Solution98();
        TreeNode left = new TreeNode(4);
        TreeNode rightSon1 = new TreeNode(3);
        TreeNode rightSon2 = new TreeNode(7);
        TreeNode right = new TreeNode(6, rightSon1, rightSon2);
        TreeNode root = new TreeNode(5, left, right);
        System.out.println(solution.isValidBST(root));
    }
}

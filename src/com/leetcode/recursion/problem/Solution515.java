package com.leetcode.recursion.problem;

import com.leetcode.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 *
 * @author 薛佳豪
 * @version V1.0
 * @since 2023-04-03 13:36:00
 */
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new LinkedList<>();
        largestValuesHelper(queue, result);
        return result;
    }

    /**
     * 广搜
     */
    public void largestValuesHelper(Queue<TreeNode> queue, List<Integer> result) {
        if (!queue.isEmpty()) {
            int max = queue.peek().val;
            for (TreeNode treeNode : queue) {
                max = Math.max(treeNode.val, max);
            }
            result.add(max);
        }
        Queue<TreeNode> sub = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                sub.add(poll.left);
            }
            if (poll.right != null) {
                sub.add(poll.right);
            }
        }
        if (!sub.isEmpty()) {
            largestValuesHelper(sub, result);
        }
    }
    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        Solution515 solution = new Solution515();
        System.out.println(solution.largestValues(root));
    }
}

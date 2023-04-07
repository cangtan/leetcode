package com.leetcode.recursion.problem;

import com.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-03 13:36:00
 */
public class Solution515 {

    /**
     * 官方题解 深搜
     * @see <a href="https://leetcode.cn/problems/find-largest-value-in-each-tree-row/solution/zai-mei-ge-shu-xing-zhong-zhao-zui-da-zh-6xbs/">官方题解</a>
     */
//    public List<Integer> largestValues(TreeNode root) {
//
//        if (root == null) {
//            return new ArrayList<Integer>();
//        }
//        List<Integer> res = new ArrayList<Integer>();
//        dfs(res, root, 0);
//        return res;
//    }
//
//    public void dfs(List<Integer> res, TreeNode root, int curHeight) {
//        if (curHeight == res.size()) {
//            res.add(root.val);
//        } else {
//            res.set(curHeight, Math.max(res.get(curHeight), root.val));
//        }
//        if (root.left != null) {
//            dfs(res, root.left, curHeight + 1);
//        }
//        if (root.right != null) {
//            dfs(res, root.right, curHeight + 1);
//        }
//    }

    /**
     * 广搜官方题解
     *
     * @see <a href="https://leetcode.cn/problems/find-largest-value-in-each-tree-row/solution/zai-mei-ge-shu-xing-zhong-zhao-zui-da-zh-6xbs/">官方题解</a>
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int maxVal = Integer.MIN_VALUE;
            while (len > 0) {
                len--;
                TreeNode t = queue.poll();
                maxVal = Math.max(maxVal, t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            res.add(maxVal);
        }
        return res;
    }

    /**
     * 广搜
     */
//    public List<Integer> largestValues(TreeNode root) {
//        if (root == null) {
//            return Collections.emptyList();
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        List<Integer> result = new LinkedList<>();
//        largestValuesHelper(queue, result);
//        return result;
//    }

//    public void largestValuesHelper(Queue<TreeNode> queue, List<Integer> result) {
//        if (!queue.isEmpty()) {
//            int max = queue.peek().val;
//            for (TreeNode treeNode : queue) {
//                max = Math.max(treeNode.val, max);
//            }
//            result.add(max);
//        }
//        Queue<TreeNode> sub = new LinkedList<>();
//        while (!queue.isEmpty()) {
//            TreeNode poll = queue.poll();
//            if (poll.left != null) {
//                sub.add(poll.left);
//            }
//            if (poll.right != null) {
//                sub.add(poll.right);
//            }
//        }
//        if (!sub.isEmpty()) {
//            largestValuesHelper(sub, result);
//        }
//    }


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

package com.leetcode.recursion.problem;

import com.leetcode.tree.TreeNode;

/**
 * 二叉树的最近公共祖先
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-30 14:18:00
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">二叉树最近公共祖先</a>
 */
public class Solution236 {

    /**
     *
     * @author <a href="https://leetcode.cn/u/jyd/">Krahets</a>
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 若 rootroot 是 p, qp,q 的 最近公共祖先 ，则只可能为以下情况之一
        // 1. p 和 q 在root的子树中，且分列在root的异侧（即分别在左、右子树中）
        // 2. p=root, 且q在root的左或右子树中
        // 3. q=root, 且p在root的左或右子树中
        // 考虑通过递归对二叉树进行先序遍历，
        // 当遇到节点 p 或 q 时返回。
        // 从底至顶回溯，当节点 p,q 在节点 root 的异侧时，
        // 节点 root 即为最近公共祖先，则向上返回 root 。
        if (root == null || root == p || root == q) {
            // 当越过叶节点，直接返回null
            // 当root等于p,q,则直接返回root
            return root;
        }
        // 开启递归左子节点, 返回值记为left
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 开启递归右子节点, 返回值记为right
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 当left为空，right不为空，p,q都不在root的左子树中，直接返回right
        if (left == null) {
            // p,q其中一个在root的右子树中，此时right指向p(假设为p)
            // p,q两节点都在root的右子树中，此时的right指向最近公共祖先节点
            return right;
        }
        // 当left不为空,right为空与上面同理
        if (right == null) {
            return left;
        }
        // left,right同时不为空,说明pq分列在root异侧，此时root为最近公共祖先，返回root
        return root;
    }

    public static void main(String[] args) {
        Solution236 solution = new Solution236();
        Solution297 solution297 = new Solution297();
        TreeNode root = solution297.deserialize("3,5,6,None,None,2,7,None,None,4,None,None,1,0,None,None,8,None,None");
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        System.out.println(solution.lowestCommonAncestor(root, p, q));
    }
}

package com.leetcode.dp.problem;

import com.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * 打家劫舍III
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-09-19 17:47:00
 */
public class Solution337 {

    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    /**
     * 用f(o)表示选择o节点的情况下，o节点的子树上被选择的节点的最大权值和；g(o)表示不选择o节点的情况下,o节点的子树上被选择的节点的最大权值和;
     * l和r代表o的左右子节点
     * 当o被选中时, o的左右孩子都不能被选中，故o被选中情况下子树上被选中点的最大权值和为l和r不被选中的最大权值和相加，即f(o)=g(l)+g(r)
     * 当o不被选中时,o的左右孩子可以被选中,也可以不被选中。对于o的某个具体的孩子x,它对o的贡献是x，被选中和不被选中情况下权值和的较大值。故
     * g(o)=max{f(l), g(l)} + max{f(r), g(r)}
     */
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return ;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
                + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 3;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        Solution337 solution = new Solution337();
        System.out.println(solution.rob(root));
    }
}

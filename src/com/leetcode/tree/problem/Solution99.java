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
     * Morris 遍历也就是经常说到的“神级遍历”，其本质是通过做大常数来降低空间复杂度。
     * 还是以二叉树的中序遍历为例，无论是递归或是迭代，为了在遍历完左节点（也可以是左子树）时，仍能回到父节点，我们需要使用数据结构栈，只不过在递归做法中是用函数调用充当栈，而在迭代做法则是显式栈。
     * 这使得空间复杂度为 O(h)O(h)O(h)，而 Morris 遍历的核心则是利用“路径底部节点”中的空闲指针进行线索。
     * <p>
     * 作者：宫水三叶的刷题日记
     * 链接：https://juejin.cn/post/7275989298197168147
     * 来源：稀土掘金
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 1.令根节点为当前节点
     * 2.只要当前节点不为空（while(root != null)), 重复执行如下流程:
     * 若当前节点的左子节点为空（root.left = null）， 将当前节点更新为其右子节点（root=root.right）
     * 若当前节点的左子节点不为空,利用临时变量t存储，找到当前节点的前驱节点（左子树中最后一个节点）：
     * 若前驱节点的右子节点为空（t.right = null）, 将前驱节点的右子节点链接到当前节点（t.right=root),并将当前节点更新为左子节点（root = root.left）
     * 若前驱节点的右子节点不为空，说明已链接到当前节点，此时将前驱节点的右子节点置空（删除链接t.right=null)，遍历当期节点,并将当前节点更新为右子节点（root = root.right）
     */
    public void recoverTreeMorris(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                if ( last != null && last.val > root.val) {
                    if (a == null) {
                        a = last; b = root;
                    } else {
                        b = root;
                    }
                }
                last = root;
                root = root.right;
            } else {
                TreeNode t = root.left;
                while (t.right != null && t.right != root) {
                    t = t.right;
                }
                if (t.right == null) {
                    t.right = root;
                    root = root.left;
                } else {
                    t.right = null;
                    if (last != null && last.val > root.val) {
                        if (a == null) {
                            a = last; b = root;
                        } else {
                            b = root;
                        }
                    }
                    last = root;
                    root = root.right;
                }
            }
        }
        int val = a.val;
        a.val = b.val;
        b.val = val;
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

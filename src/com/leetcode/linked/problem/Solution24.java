package com.leetcode.linked.problem;

import com.leetcode.linked.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author ives
 * @version V1.0
 * @date 2021-05-26 14:43:00
 * @link https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Solution24 {
    /**
     * 起初是循环处理，但是发现两两交换会导致从A->B->C->D 变成 B->A->C->D->C
     * 发现这个问题后想到的就是递归, 交换完后再指向,因此使用递归,完成下一次交换才能让上一次的交换有指向
     * @param head 链表
     * @return 交换节点后的链表
     */
    public ListNode swapPairs(ListNode head) {
        if (head !=null && head.next != null){
            ListNode temp = head.next.next;
            ListNode prev = head.next;
            prev.next = head;
            head.next = swapPairs(temp);
            return prev;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.init(nums);
        Solution24 solution24 = new Solution24();
        ListNode.print(solution24.swapPairs(head));
    }
}

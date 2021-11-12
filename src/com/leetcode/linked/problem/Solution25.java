package com.leetcode.linked.problem;

import com.leetcode.linked.ListNode;

/**
 * K个一组反转链表
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-11-12 14:11:00
 * @link https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class Solution25 {
    /**
     * 自己的解法
     * 递归
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 首先想到的是通过递归的方式让后续的链表返回的接着前面的节点
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int count = 0;
        // 题目要求当所剩下的不满足k的整数倍，则不改变顺序
        ListNode countPoint = head;
        while (countPoint != null) {
            countPoint = countPoint.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode prev = null;
        ListNode temp = null;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (head != null) {
                // 存储原先的下一个节点
                temp = head.next;
                // 下一个节点指向上一个节点
                head.next = prev;
                // 自身变为前一个节点
                prev = head;
                head = temp;
            }
        }
        end.next = reverseKGroup(head, k);
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.init(nums);
        Solution25 solution25 = new Solution25();
        ListNode listNode = solution25.reverseKGroup(head, 3);
        ListNode.print(listNode);
    }

    /**
     * 也是递归的方法，但是写的比我好太多了
     *
     * @author shpolsky
     * @link https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        // find the k+1 node
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        // if k+1 node is found
        if (count == k) {
            // reverse list with k+1 node as head
            curr = reverseKGroup1(curr, k);
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part
            // reverse current k-group
            while (count-- > 0) {
                // tmp - next head in direct part
                ListNode tmp = head.next;
                // preappending "direct" head to the reversed list
                head.next = curr;
                // move head of reversed part to a new node
                curr = head;
                // move "direct" head to the next node in direct part
                head = tmp;
            }
            head = curr;
        }
        return head;
    }

    /**
     * 这个使用循环的方式
     *
     * @author yellowstone
     * @link https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11440/Non-recursive-Java-solution-and-idea
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;

    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode first = curr;
        ListNode prev = begin;

        ListNode next;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }
}

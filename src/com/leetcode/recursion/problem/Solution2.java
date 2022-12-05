package com.leetcode.recursion.problem;

import com.leetcode.linked.ListNode;

/**
 * 两数相加
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/add-two-numbers/">两数相加</a>
 * @since 2022-12-05 11:30:00
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calc(l1, l2, 0);
    }

    public ListNode calc(ListNode l1, ListNode l2, int aNumber) {
        if (l1 == null && l2 == null) {
            if (aNumber != 0) {
                return new ListNode(aNumber);
            } else {
                return null;
            }
        }
        int n1 = 0;
        int n2 = 0;
        if (l1 != null) {
            n1 = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            n2 = l2.val;
            l2 = l2.next;
        }
        int sum = n1 + n2 + aNumber;
        int tenth = sum / 10;
        ListNode root = new ListNode(sum % 10);
        root.next = calc(l1, l2, tenth);
        return root;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        ListNode l1Node3 = new ListNode(3);
        ListNode l1Node2 = new ListNode(4);
        l1Node2.next = l1Node3;
        ListNode l1Node1 = new ListNode(2);
        l1Node1.next = l1Node2;

        ListNode l2Node3 = new ListNode(4);
        ListNode l2Node2 = new ListNode(6);
        l2Node2.next = l2Node3;
        ListNode l2Node1 = new ListNode(5);
        l2Node1.next = l2Node2;

        ListNode listNode = solution.addTwoNumbers(l1Node1, l2Node1);
        ListNode.print(listNode);
    }
}

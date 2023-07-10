package com.leetcode.linked.problem;

import com.leetcode.linked.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第N个节点
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-07 16:56:00
 */
public class Solution19 {
    /**
     * 二次扫描
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode point = head;
        int cnt = 0;
        while (point != null) {
            cnt++;
            point = point.next;
        }
        if (n == cnt) {
            return head.next;
        }
        point = head;
        int removeI = cnt - n;
        int curI = 0;
        while (point != null) {
            if (curI == removeI - 1) {
                if (removeI != cnt) {
                    // 非末尾
                    point.next = point.next.next;
                } else {
                    point.next = null;
                }
            }
            curI++;
            point = point.next;
        }
        return head;
    }

    public ListNode removeNthFromEndByStack(ListNode head, int n) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode point = head;
        while (point != null) {
            stack.push(point);
            point = point.next;
        }
        for (int i = n - 1; i > 0; i--) {
            stack.pop();
        }
        ListNode remove = stack.pop();
        if (stack.peek() != null) {
            stack.peek().next = remove.next;
        } else {
            head = remove.next;
        }
        return head;
    }

    public ListNode removeNthFromEndByPoint(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode linked = ListNode.init(new int[]{1});
        Solution19 solution = new Solution19();
        ListNode result = solution.removeNthFromEndByPoint(linked, 1);
        ListNode.print(result);
    }
}

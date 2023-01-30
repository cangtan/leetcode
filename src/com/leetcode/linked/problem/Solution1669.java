package com.leetcode.linked.problem;

import com.leetcode.linked.ListNode;

/**
 * 合并两个链表
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-30 13:45:00
 */
public class Solution1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i = 0;
        ListNode head = list1;
        while (list1.next != null) {
            if (i == a - 1) {
                ListNode temp = list1.next;
                list1.next = list2;
                list1 = temp;
            } else if (i == b) {
                while (list2.next != null) {
                    list2 = list2.next;
                }
                list2.next = list1.next;
                break;
            } else {
                list1 = list1.next;
            }
            i++;
        }
        return head;
    }

    /**
     * 官方题解
     *
     * @author leetcode官方
     * @see <a href = "https://leetcode.cn/problems/merge-in-between-linked-lists/solution/he-bing-liang-ge-lian-biao-by-leetcode-s-alt8/">官方题解</a>
     */
//    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
//        ListNode preA = list1;
//        for (int i = 0; i < a - 1; i++) {
//            preA = preA.next;
//        }
//        ListNode preB = preA;
//        for (int i = 0; i < b - a + 2; i++) {
//            preB = preB.next;
//        }
//        preA.next = list2;
//        while (list2.next != null) {
//            list2 = list2.next;
//        }
//        list2.next = preB;
//        return list1;
//    }

    public static void main(String[] args) {
        Solution1669 solution = new Solution1669();
        ListNode list1 = new ListNode();
        list1.val = 0;
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);
        ListNode list2 = new ListNode();
        list2.val = 1000000;
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);
        int a = 3;
        int b = 4;
        ListNode listNode = solution.mergeInBetween(list1, a, b, list2);
        ListNode.print(listNode);

    }
}

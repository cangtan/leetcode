package com.leetcode.recursion.problem;

import com.leetcode.linked.ListNode;

/**
 * 合并两个有序链表
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">合并两个有序链表</a>
 * @since 2022-12-05 11:59:00
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = list1.val < list2.val ? list1 : list2;
        res.next = mergeTwoLists(res.next, list1.val >= list2.val ? list1 : list2);
        return res;
    }

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        // 自己的丑陋代码
//        if (list1 == null) {
//            return list2;
//        }
//        if (list2 == null) {
//            return list1;
//        }
//        if (list1.val <= list2.val) {
//            list1.next = mergeTwoLists(list1.next, list2);
//        } else {
//            ListNode temp = list1;
//            list1 = list2;
//            list1.next = mergeTwoLists(temp, list2.next);
//        }
//        return list1;
//    }

    public static void main(String[] args) {

//        ListNode l1Node3 = new ListNode(4);
        ListNode l1Node2 = new ListNode(3);
//        l1Node2.next = l1Node3;
        ListNode l1Node1 = new ListNode(-9);
        l1Node1.next = l1Node2;

//        ListNode l2Node3 = new ListNode(4);
        ListNode l2Node2 = new ListNode(7);
//        l2Node2.next = l2Node3;
        ListNode l2Node1 = new ListNode(5);
        l2Node1.next = l2Node2;

        Solution21 solution = new Solution21();
        ListNode listNode = solution.mergeTwoLists(l1Node1, l2Node1);
        ListNode.print(listNode);

    }
}

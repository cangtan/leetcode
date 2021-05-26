package com.leetcode.linked;

/**
 * Node
 *
 * @author ives
 * @version V1.0
 * @date 2021-05-26 13:58:00
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode init(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode point = head;
        for (int i = 1; i < array.length; i++) {
            point.next = new ListNode(array[i]);
            point = point.next;
        }
        return head;
    }

    public static void print(ListNode head){
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

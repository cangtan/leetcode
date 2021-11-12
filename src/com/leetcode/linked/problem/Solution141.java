package com.leetcode.linked.problem;

import com.leetcode.linked.ListNode;

/**
 * 环形链表
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-05-26 15:29:00
 * @link https://leetcode-cn.com/problems/linked-list-cycle/
 * 快慢指针
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (slow != null && quick != null) {
            slow = slow.next;
            quick = quick.next;
            if(quick != null) {
                quick = quick.next;
            } else {
                return false;
            }
            if (slow == quick) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        ListNode head = ListNode.init(nums);
        Solution141 solution141 = new Solution141();
        System.out.println(solution141.hasCycle(head));
    }
}

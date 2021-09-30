package com.leetcode.linked.problem;

import com.leetcode.linked.ListNode;

/**
 * 环型链表2
 *
 * @author 薛佳豪
 * @version V1.0
 * @date 2021-09-30 15:15:00
 * @link https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode faster = head;
        while (slow != null) {
            slow = slow.next;
            if (faster != null && faster.next != null) {
                faster = faster.next.next;
                if (slow == faster) {
                    // fast指针走过的距离都为slow的2倍
                    // 设起点到环点为a, slow入环后与fast相遇的距离为b, slow与fast的相遇点到环点的距离为c
                    // n为fast绕过的圈数
                    // 则fast走过的距离为a + n(b + c) + b = a + (n + 1)b + nc
                    // ∵ fast = 2slow
                    // ∴ a + (n + 1)b + nc = 2(a + b)
                    // ∴ a = c + (n - 1)(b + c)
                    // 所以b+c为环的距离, 所以a到环点的距离=c到环点的距离
                    ListNode start = head;
                    while (start != slow) {
                        start = start.next;
                        slow = slow.next;
                    }
                    return start;
                }
            } else {
                break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = init();
        Solution142 solution142 = new Solution142();
        System.out.println(solution142.detectCycle(head).val);
    }

    public static ListNode init() {
        int[] array = {3, 2, 0, -4};
        int pos = 1;
        int index = 0;
        ListNode head = ListNode.init(array);
        ListNode point = head;
        ListNode linkedPoint = null;
        while (point.next != null) {
            if (index == pos) {
                linkedPoint = point;
            }
            index++;
            point = point.next;
        }
        point.next = linkedPoint;
        return head;
    }
}

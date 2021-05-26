package com.leetcode.linked.problem;

import com.leetcode.array.problem.Solution15;
import com.leetcode.linked.ListNode;

import javax.swing.*;
import java.util.List;

/**
 * 反转链表
 *
 * @author ives
 * @version V1.0
 * @date 2021-05-26 13:56:00
 * @link https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Solution206 {

    /**
     * A->B->C
     * 第一次反转 A.next -> null, current保存B->C, prev保存A
     * 第二次反转 此时链表断链,产生了两条 A->null, B->C 遍历位置从B开始
     * 第三次反转 B->A, C 遍历位置从C开始
     * @param head 链表
     * @return 链表
     */
    public ListNode reverseList(ListNode head) {
        // 反向链
        ListNode prev = null;
        // 临时链
        ListNode temp;
        while (head != null){
            // 将链表分为head链(正向链 和prev链(正向链 current指向下一节点
            // 保存正向链 B->C
            temp = head.next;
            // 反转
            head.next = prev;
            // 保存反向链
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.init(nums);
        Solution206 solution206 = new Solution206();
        ListNode.print(solution206.reverseList(head));
    }
}

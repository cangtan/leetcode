package com.leetcode.stack.problem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 餐盘栈
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-28 13:46:00
 */
public class Solution1172 {
    private static class DinnerPlates {

        private List<Deque<Integer>> queue = new ArrayList<>();

        private PriorityQueue<Integer> priority = new PriorityQueue<>();

        int point = -1;

        int capacity;

        /**
         * 如何实现缓存
         * 1.正常情况
         * push capacity 满了后 left+=1, right=left
         * pop capacity = 0 后 right-=1, left=right;
         * 2.非正常情况即执行了popAtStack此时是随机取数
         * popAsStack.index > right 直接返回-1
         * popAsStack.index <= right 则随机访问arr获取值, 此时会造成前面的栈空了（优先队列）
         */
        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            if (queue.isEmpty()) {
                queue.add(new LinkedList<>());
            }
            if (point < 0) {
                point = 0;
            }
            int temp = point;
            if (!priority.isEmpty()) {
                int poll = priority.poll();
                temp = Math.min(poll, point);
            }
            Deque<Integer> deque = queue.get(temp);
            if (deque.size() < capacity) {
                deque.offerFirst(val);
            } else {
                if (temp == point) {
                    point += 1;
                }
                if (point >= queue.size()) {
                    Deque<Integer> newStack = new LinkedList<>();
                    newStack.add(val);
                    queue.add(newStack);
                } else {
                    queue.get(point).offerFirst(val);
                }
            }
        }

        public int pop() {
            if (point == -1) {
                return -1;
            }
            int element = -1;
            for (int i = point; i >= 0; i--) {
                Deque<Integer> deque = queue.get(i);
                if (deque.isEmpty()) {
                    point--;
                } else {
                    element = deque.pop();
                    if (deque.isEmpty()) {
                        point--;
                    }
                    break;
                }
            }
            return element;
        }

        public int popAtStack(int index) {
            //挖空
            // 不能大于当前最右侧point
            if (index > point) {
                return -1;
            }
            Deque<Integer> deque = queue.get(index);
            if (deque.isEmpty()) {
                if (index == point) {
                    point--;
                }
                return -1;
            }
            int element = deque.pop();
            priority.offer(index);
            return element;
        }
    }

    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        DinnerPlates dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);
        System.out.println(dinnerPlates.popAtStack(0));   // 返回 2
        dinnerPlates.push(20);
        dinnerPlates.push(21);
        System.out.println(dinnerPlates.popAtStack(0));   // 返回 20
        System.out.println(dinnerPlates.popAtStack(2));   // 返回 21
        System.out.println(dinnerPlates.pop());            // 返回 5
        System.out.println(dinnerPlates.pop());            // 返回 4。
        System.out.println(dinnerPlates.pop());            // 返回 3。
        System.out.println(dinnerPlates.pop());            // 返回 1。现在没有栈。
        System.out.println(dinnerPlates.pop());           // 返回 -1。仍然没有栈。
    }

    private static void test2() {
        DinnerPlates dinnerPlates = new DinnerPlates(1);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        System.out.println(dinnerPlates.popAtStack(1));
        System.out.println(dinnerPlates.pop());
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
    }
}

package com.leetcode.queue.dequeue;

/**
 * 设计循环双端队列
 *
 * @author 薛佳豪
 * @version V1.0
 * @date 2021-12-16 16:52:00
 */
public class MyCircularDeque {
    private MyLinkedList head;
    private MyLinkedList tail;
    private int use = 0;
    private int size = 0;

    public MyCircularDeque(int k) {
        size = k;
    }

    public boolean insertFront(int value) {
        if (use + 1 > size) {
            return false;
        }
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.setValue(value);
        if (use == 0) {
            head = myLinkedList;
            tail = myLinkedList;
        } else {
            head.setPrev(myLinkedList);
            myLinkedList.setNext(head);
            head = myLinkedList;
        }
        use += 1;
        return true;
    }

    public boolean insertLast(int value) {
        if (use + 1 > size) {
            return false;
        }
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.setValue(value);
        if (use == 0) {
            head = myLinkedList;
            tail = myLinkedList;
        } else {
            tail.setNext(myLinkedList);
            myLinkedList.setPrev(tail);
            tail = myLinkedList;
        }
        use += 1;
        return true;
    }

    public boolean deleteFront() {
        if (use == 0) {
            return false;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = head;
        }
        use -= 1;
        return true;
    }

    public boolean deleteLast() {
        if (use == 0) {
            return false;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = tail;
        }
        use -= 1;
        return true;
    }

    public int getFront() {
        return head == null ? -1 : head.value;
    }

    public int getRear() {
        return tail == null ? -1 : tail.value;
    }

    public boolean isEmpty() {
        return use == 0;
    }

    public boolean isFull() {
        return use == size;
    }

    static class MyLinkedList {
        int value;
        MyLinkedList prev;
        MyLinkedList next;

        public MyLinkedList() {
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public MyLinkedList getPrev() {
            return prev;
        }

        public void setPrev(MyLinkedList prev) {
            this.prev = prev;
        }

        public MyLinkedList getNext() {
            return next;
        }

        public void setNext(MyLinkedList next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque2 myCircularDeque = new MyCircularDeque2(4);
        System.out.println(myCircularDeque.insertFront(9));
        System.out.println(myCircularDeque.insertLast(6));
        System.out.println(myCircularDeque.insertLast(5));
    }
}

/**
 * 数组双指针写法, 头尾指针向数组内部移动
 * 🐂🍺
 * @author verygoodlee
 */
class MyCircularDeque2 {
    private final int[] elements;
    private int size = 0, head = 0, tail;
    public MyCircularDeque2(int k) {
        elements = new int[k];
        tail = k - 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        elements[head = head == 0 ? elements.length - 1 : head - 1] = value;// 头指针左移
        size++;
        return true;
    }
    public boolean insertLast(int value) {
        if (isFull()) return false;
        elements[tail = tail == elements.length - 1 ? 0 : tail + 1] = value;// 尾指针右移
        size++;
        return true;
    }
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = head == elements.length - 1 ? 0 : head + 1;// 头指针右移
        size--;
        return true;
    }
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = tail == 0 ? elements.length - 1 : tail - 1;// 尾指针左移
        size--;
        return true;
    }
    public int getFront() {
        if (isEmpty()) return -1;
        return elements[head];
    }
    public int getRear() {
        if (isEmpty()) return -1;
        return elements[tail];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == elements.length;
    }
}


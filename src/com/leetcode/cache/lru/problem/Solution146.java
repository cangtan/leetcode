package com.leetcode.cache.lru.problem;


import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-19 16:47:00
 */
public class Solution146 {
    class LRUCache {
        private int capacity;

        private Node head;

        private Node tail;

        private int size = 0;

        Map<Integer, Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            modify(key, node.val);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                modify(key, value);
                return;
            }
            if (size == capacity) {
                unlinkLast();
            }
            add(key, value);
        }

        public void add(int key, int value) {
            Node first = head;
            Node newNode = new Node(key, value, first);
            head = newNode;
            if (first == null) {
                tail = newNode;
            } else {
                first.prev = newNode;
            }
            map.put(key, newNode);
            size++;
        }

        public void modify(int key, int value) {
            Node oldNode = map.get(key);
            remove(oldNode.key);
            add(key, value);
        }

        public void remove(int key) {
            Node node = map.get(key);
            Node prev = node.prev;
            Node next = node.next;
            if(prev == null) {
                head = next;
            } else {
                prev.next = next;
            }
            if (next == null) {
                tail = prev;
            } else {
                next.prev = prev;
            }
            size--;
        }

        public void unlinkLast() {
            if (tail == null) {
                return;
            }
            map.remove(tail.key);
            Node prev = tail.prev;
            tail.prev = null;
            tail = prev;
            if (prev == null) {
                head = null;
            } else {
                prev.next = null;
            }
            size--;
        }
    }

    class Node {
        public Node prev;
        public Node next;
        public int val;

        public int key;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        test3();
    }

    public static void test1() {
        Solution146 solution = new Solution146();
        LRUCache lruCache = solution.new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    public static void test2() {
        Solution146 solution = new Solution146();
        LRUCache lruCache = solution.new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(2));
    }

    public static void test3() {
        Solution146 solution = new Solution146();
        LRUCache lruCache = solution.new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}

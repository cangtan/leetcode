package com.leetcode.recursion.problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 组合
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/combinations/">组合</a>
 * @since 2022-12-01 14:47:00
 */
public class Solution77 {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> item = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    public void combineHelper(int n, int k, int i) {
        if (item.size() == k) {
            result.add(new LinkedList<>(item));
            return;
        }
        for (int j = i; j <= n - (k - item.size()) + 1; j++) {
            item.add(j);
            combineHelper(n, k, j + 1);
            item.removeLast();
        }
    }

//    /**
//     * 自己写的有点丑陋了
//     */
//    private final List<List<Integer>> result = new LinkedList<>();
//    public List<List<Integer>> combine(int n, int k) {
//        if (k == 0) {
//            return result;
//        }
//        for (int i = 1; i <= n - k + 1; i++) {
//            List<Integer> item = new LinkedList<>();
//            item.add(i);
//            recursion(item, i + 1, n, k - 1);
//        }
//        return result;
//    }
//
//    public void recursion(List<Integer> item, int i, int n, int k) {
//        if (k > 0) {
//            for (int j = i; j <= n; j++) {
//                List<Integer> newItem = new LinkedList<>(item);
//                newItem.add(j);
//                recursion(newItem, j + 1, n, k - 1);
//            }
//        } else {
//            result.add(item);
//        }
//    }

    public static void main(String[] args) {
        Solution77 solution = new Solution77();
        int n = 4;
        int k = 3;
        System.out.println(solution.combine(n, k));
    }
}

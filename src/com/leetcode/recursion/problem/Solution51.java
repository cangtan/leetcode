package com.leetcode.recursion.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-09 14:32:00
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> slash = new HashSet<>();
        Set<Integer> backslash = new HashSet<>();
        int[] queens = new int[n];
        solveHelper(result, queens, col, slash, backslash, 0, n);
        return result;
    }

    public void solveHelper(List<List<String>> result,
                            int[] queens,
                            Set<Integer> colSet,
                            Set<Integer> slashSet,
                            Set<Integer> backslashSet,
                            int row,
                            int n) {
        if (row == n) {
            List<String> resultItemList = generateBoard(queens);
            result.add(resultItemList);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (colSet.contains(i)) {
                continue;
            }
            int slash = row + i;
            if (slashSet.contains(slash)) {
                continue;
            }
            int backslash = row - i;
            if (backslashSet.contains(backslash)) {
                continue;
            }
            queens[row] = i;
            colSet.add(i);
            slashSet.add(slash);
            backslashSet.add(backslash);
            solveHelper(result, queens, colSet, slashSet, backslashSet, row + 1, n);
            colSet.remove(i);
            slashSet.remove(slash);
            backslashSet.remove(backslash);
        }
    }

    public List<String> generateBoard(int[] queens) {
        int n = queens.length;
        List<String> resultItem = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[queens[i]] = 'Q';
            resultItem.add(new String(chars));
        }
        return resultItem;
    }

    public static void main(String[] args) {
        Solution51 solution = new Solution51();
        List<List<String>> result = solution.solveNQueens(4);
        System.out.println(result);
    }
}

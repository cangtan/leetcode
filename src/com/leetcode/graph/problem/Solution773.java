package com.leetcode.graph.problem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 滑动谜题
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-16 16:31:00
 */
public class Solution773 {

    int[][] swapMap = {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
    };

    Set<String> visited = new HashSet<>();

    public int slidingPuzzle(int[][] board) {
        StringBuilder startStr = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                startStr.append(board[i][j]);
            }
        }
        final String target = "123450";
        if (target.equals(startStr.toString())) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(startStr.toString());
        visited.add(startStr.toString());
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                startStr = new StringBuilder(poll);
                int index = startStr.indexOf("0");
                for (int replace : swapMap[index]) {
                    String temp = String.valueOf(startStr.charAt(replace));
                    startStr.replace(replace, replace + 1, "0");
                    startStr.replace(index, index + 1, temp);
                    String nextStr = startStr.toString();
                    if (target.equals(nextStr)) {
                        return step + 1;
                    }
                    if (!visited.contains(nextStr)) {
                        visited.add(nextStr);
                        queue.add(nextStr);
                    }
                    startStr.replace(replace, replace + 1, temp);
                    startStr.replace(index, index + 1, "0");
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution773 solution = new Solution773();
        int[][] board = {
                {4, 1, 2}, {5, 0, 3}
        };
        System.out.println(solution.slidingPuzzle(board));
    }
}

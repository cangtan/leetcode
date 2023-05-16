package com.leetcode.graph.problem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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

    /**
     * 启发式搜索
     */
    public int slidingPuzzleAStar(int[][] board) {
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
        PriorityQueue<AStar> queue = new PriorityQueue<>((a, b) -> a.f - b.f);
        queue.add(new AStar(startStr.toString(), 0));
        visited.add(startStr.toString());
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                AStar poll = queue.poll();
                for (AStar aStar : listNext(poll)) {
                    if (target.equals(aStar.status)) {
                        return aStar.g;
                    }
                    if (!visited.contains(aStar.status)) {
                        visited.add(aStar.status);
                        queue.add(aStar);
                    }
                }
            }
        }
        return -1;
    }

    private List<AStar> listNext(AStar aStar) {
        List<AStar> result = new LinkedList<>();
        int index = aStar.status.indexOf("0");
        char[] chars = aStar.status.toCharArray();
        for (int i : swapMap[index]) {
            swap(chars, i, index);
            result.add(new AStar(new String(chars), aStar.g + 1));
            swap(chars, i, index);
        }
        return result;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static class AStar {
        public static int[][] dist = {
                {0, 1, 2, 1, 2, 3},
                {1, 0, 1, 2, 1, 2},
                {2, 1, 0, 3, 2, 1},
                {1, 2, 3, 0, 1, 2},
                {2, 1, 2, 1, 0, 1},
                {3, 2, 1, 2, 1, 0}
        };
        private String status;
        private int f;
        private int g;
        private int h;

        public AStar(String status, int g) {
            this.status = status;
            this.g = g;
            this.h = getH(status);
            this.f = this.g + this.h;
        }

        public int getH(String status) {
            int result = 0;
            for (int i = 0; i < 6; i++) {
                char ch = status.charAt(i);
                if (ch != '0') {
                    result += dist[i][ch - '1'];
                }
            }
            return result;
        }

    }

    public static void main(String[] args) {
        Solution773 solution = new Solution773();
        int[][] board = {
                {4, 1, 2}, {5, 0, 3}
        };
        System.out.println(solution.slidingPuzzleAStar(board));
    }
}

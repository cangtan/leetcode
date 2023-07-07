package com.leetcode.other.problem;

import java.util.PriorityQueue;

/**
 * 过桥的时间
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-07 10:15:00
 */
public class Solution2532 {
    public int findCrossingTime(int n, int k, int[][] time) {
        PriorityQueue<Integer> left = new PriorityQueue<>((x, y) -> {
            int timeX = time[x][0] + time[x][2];
            int timeY = time[y][0] + time[y][2];
            return timeX != timeY ? timeY - timeX : y - x;
        });
        PriorityQueue<Integer> right = new PriorityQueue<>((x, y) -> {
            int timeX = time[x][0] + time[x][2];
            int timeY = time[y][0] + time[y][2];
            return timeX != timeY ? timeY - timeX : y - x;
        });
        PriorityQueue<int[]> pick = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        PriorityQueue<int[]> put = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        // 所有工人在左侧等候
        for (int i = 0; i < k; i++) {
            left.offer(i);
        }
        int currentTime = 0;
        while (n > 0 || !pick.isEmpty() || !right.isEmpty()) {
            while (!pick.isEmpty() && pick.peek()[0] <= currentTime) {
                int[] wait = pick.poll();
                right.offer(wait[1]);
            }
            while (!put.isEmpty() && put.peek()[0] <= currentTime) {
                int[] wait = put.poll();
                left.offer(wait[1]);
            }
            if (!right.isEmpty()) {
                Integer rightGo = right.poll();
                currentTime += time[rightGo][2];
                put.offer(new int[]{currentTime + time[rightGo][3], rightGo});
            } else if (n > 0 && !left.isEmpty()) {
                Integer leftGo = left.poll();
                currentTime += time[leftGo][0];
                pick.offer(new int[]{currentTime + time[leftGo][1], leftGo});
                n--;
            } else {
                int nextTime = Integer.MAX_VALUE;
                if (!pick.isEmpty()) {
                    nextTime = Math.min(nextTime, pick.peek()[0]);
                }
                if (!put.isEmpty()) {
                    nextTime = Math.min(nextTime, put.peek()[0]);
                }
                if (nextTime != Integer.MAX_VALUE) {
                    currentTime = Math.max(nextTime, currentTime);
                }
            }
        }
        return currentTime;
    }

    public static void main(String[] args) {
        Solution2532 solution = new Solution2532();
        int n = 1;
        int k = 3;
        int[][] time = {
                {1, 1, 2, 1},
                {1, 1, 3, 1},
                {1, 1, 4, 1}
        };
        System.out.println(solution.findCrossingTime(n, k, time));
    }
}

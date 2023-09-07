package com.leetcode.search.binary;

/**
 * 修车的最少时间
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-09-07 17:38:00
 */
public class Solution2594 {
    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = (long) ranks[0] * cars * cars;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (calc(ranks, mid) >= cars) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public long calc(int[] ranks, long mid) {
        long cnt = 0;
        for (int rank : ranks) {
            cnt += Math.sqrt((double) mid / rank);
        }
        return cnt;
    }


    public static void main(String[] args) {
        Solution2594 solution = new Solution2594();
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;
        System.out.println(solution.repairCars(ranks, cars));
    }
}

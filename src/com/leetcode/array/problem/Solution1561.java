package com.leetcode.array.problem;

import java.util.Arrays;

/**
 * 1561. 你可以获得的最大硬币数目
 *
 * @author cangtan
 * @since 2025/1/22 13:20
 */
public class Solution1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int times = piles.length / 3;
        boolean selected = false;
        int result = 0;
        for (int i = piles.length - 1; i >= 0 && times > 0; i--) {
            if (selected) {
                selected = false;
                times--;
                result += piles[i];
            } else {
                selected = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1561 solution = new Solution1561();
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr = new int[]{2, 4, 1, 2, 7, 8};
        System.out.println(solution.maxCoins(arr));
    }
}

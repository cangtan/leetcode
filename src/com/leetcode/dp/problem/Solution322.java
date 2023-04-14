package com.leetcode.dp.problem;

import com.sun.deploy.panel.ITreeNode;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-14 13:52:00
 */
public class Solution322 {
    /**
     * f(i) = Math.min(f(i - coins[0]) + 1, f(i - coins[1]) + 1, ... f(i - coins[j]) + 1)
     */
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        Arrays.fill(count, amount + 1);
        count[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    count[i] =Math.min(count[i], count[i - coin] + 1);
                }
            }
        }
        return count[amount] > amount ? -1 : count[amount];
    }

    public static void main(String[] args) {
        Solution322 solution = new Solution322();
        int[] coins = {2, 5, 10, 1};
        int amount = 27;
        /**
         * [1, 1, 1]
         *
         * fn(11) -> fn(10)-> fn(9) ...->fn(1)
         * fn(2) & fn(1) -- 1 1 2 2 1 2 2 3 3 2 3 3 4 4 3
         */
        System.out.println(solution.coinChange(coins, amount));
    }
}

package com.leetcode.greedy.problem;

/**
 * 柠檬水找零
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-07 14:01:00
 */
public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int wallet5 = 0;
        int wallet10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                wallet5++;
            } else if (bill == 10) {
                if (wallet5 == 0) {
                    return false;
                }
                wallet10++;
                wallet5--;
            } else {
                if (wallet10 > 0 && wallet5 > 0) {
                    wallet10--;
                    wallet5--;
                } else if (wallet5 >= 3) {
                    wallet5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution860 solution = new Solution860();
        int[] bills = {5, 5, 10, 10, 20};
        System.out.println(solution.lemonadeChange(bills));
    }
}

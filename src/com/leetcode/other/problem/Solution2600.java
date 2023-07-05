package com.leetcode.other.problem;

/**
 * K件物品的最大和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-05 15:36:00
 */
public class Solution2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int result = 0;
        if (numOnes >= k) {
            result += k;
            k -= k;
        } else {
            result = numOnes;
            k -= numOnes;
        }
        k -= numZeros;
        if (k > 0) {
            result -= Math.min(numNegOnes, k);
        }
        return result;
    }

    public int kItemsWithMaximumSum2(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k <= numOnes + numZeros) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }

    public static void main(String[] args) {
        Solution2600 solution = new Solution2600();
        System.out.println(solution.kItemsWithMaximumSum(1, 4, 1, 3));
    }
}

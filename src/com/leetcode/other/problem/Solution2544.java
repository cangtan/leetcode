package com.leetcode.other.problem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 交替数字和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-12 15:48:00
 */
public class Solution2544 {
    public int alternateDigitSum(int n) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (n > 0) {
            stack.push(n % 10);
            n /= 10;
        }
        boolean isPositive = true;
        while (!stack.isEmpty()) {
            if (isPositive) {
                result += stack.pop();
            } else {
                result -= stack.pop();
            }
            isPositive = !isPositive;
        }
        return result;
    }

    public int alternateDigitSum2(int n) {
        int result = 0;
        while (n > 0) {
            result = n % 10 - result;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2544 solution = new Solution2544();
        int n = 886996;
        System.out.println(solution.alternateDigitSum(n));
    }
}

package com.leetcode.recursion.problem;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-28 15:19:00
 * @see <a href="https://leetcode.cn/problems/generate-parentheses/">括号生成</a>
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        bracket(result, "(", n, 1, 0);
        return result;
    }

    private void bracket(List<String> result, String bracket, int n, int left, int right) {
        if (left == right && left == n) {
            result.add(bracket);
        }
        if (left < n) {
            bracket(result, bracket + "(", n, left + 1, right);
        }
        if (right < left) {
            bracket(result, bracket + ")", n, left, right + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution22 solution = new Solution22();
        System.out.println(solution.generateParenthesis(n));
    }
}

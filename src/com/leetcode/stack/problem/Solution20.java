package com.leetcode.stack.problem;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * 有效的括号
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-11-12 16:23:00
 * @link https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Solution20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> hash = new HashMap<>(3);
        hash.put(')', '(');
        hash.put('}', '{');
        hash.put(']', '[');
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (hash.containsKey(aChar)) {
                if (stack.isEmpty() || !Objects.equals(hash.get(aChar), stack.pop())) {
                    return false;
                }
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("]"));
    }
}

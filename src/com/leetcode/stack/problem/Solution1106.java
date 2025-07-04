package com.leetcode.stack.problem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 解析布尔表达式
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/parsing-a-boolean-expression/">解析布尔表达式</a>
 * @since 2022-11-11 18:06:00
 */
public class Solution1106 {

    /**
     * leetcode 提交记录 0ms
     * 递归求解
     */
    public boolean parseBoolExpr(String expression) {
        return parse(expression.toCharArray(), 0, expression.length() - 1);
    }

    private boolean parse(char[] s, int lo, int hi){
        char c = s[lo];
        if(lo == hi) return c == 't';
        if(c == '!') return !parse(s, lo + 2, hi - 1);
        for(int i = lo + 2; i < hi; i += 2){
            if(s[i] == 'f' && c == '&') return false;
            if(s[i] == 't' && c == '|') return true;
            if(s[i] != 'f' && s[i] != 't'){
                int j = i + 2, cnt = 1;
                while (j < hi && cnt > 0){
                    if(s[j] == '(') cnt++;
                    if(s[j] == ')') cnt--;
                    j++;
                }
                boolean temp = parse(s, i, j - 1);
                if(!temp && c == '&') return false;
                if(temp && c == '|') return true;
                i = j - 1;
            }
        }
        return c == '&'; // 中间过程没有短路逻辑，那么与运算说明全为真，或运算都是假
    }

//    /**
//     * 利用栈，当遇到')'的时候出栈,计算结果后再次入栈, 最后栈中剩余最后的结果值
//     * @author rock
//     */
//    public boolean parseBoolExpr(String expression) {
//        Deque<Character> stk = new ArrayDeque<>();
//        for (int i = 0; i < expression.length(); ++i) {
//            char c = expression.charAt(i);
//            if (c == ')') {
//                Set<Character> seen = new HashSet<>();
//                while (stk.peek() != '(')
//                    seen.add(stk.pop());
//                stk.pop();// pop out '('.
//                char operator = stk.pop(); // get operator for current expression.
//                if (operator == '&') {
//                    stk.push(seen.contains('f') ? 'f' : 't'); // if there is any 'f', & expression results to 'f'
//                }else if (operator == '|') {
//                    stk.push(seen.contains('t') ? 't' : 'f'); // if there is any 't', | expression results to 't'
//                }else { // ! expression.
//                    stk.push(seen.contains('t') ? 'f' : 't'); // Logical NOT flips the expression.
//                }
//            }else if (c != ',') {
//                stk.push(c);
//            }
//        }
//        return stk.pop() == 't';
//    }

//    public boolean parseBoolExpr(String expression) {
//        // 自己写的 丑陋
//        Deque<Character> stack = new LinkedList<>();
//        for (int i = 0; i < expression.length(); i++) {
//            char c = expression.charAt(i);
//            if (c == ')') {
//                Boolean cacheAnd = null;
//                Boolean cacheOr = null;
//                while (!stack.isEmpty() && (stack.peek().equals('t') || stack.peek().equals('f'))){
//                    boolean b = stack.pop().equals('t');
//                    cacheAnd = cacheAnd == null ? b : cacheAnd && b;
//                    cacheOr = cacheOr == null ? b : cacheOr || b;
//                }
//                stack.pop();
//                Character symbol = stack.pop();
//                char result = 0;
//                if (symbol.equals('&')) {
//                    result = Boolean.TRUE.equals(cacheAnd) ? 't' : 'f';
//                } else if (symbol.equals('|')){
//                    result = Boolean.TRUE.equals(cacheOr) ? 't' : 'f';
//                } else if (symbol.equals('!')){
//                    result = Boolean.TRUE.equals(cacheAnd) ? 'f' : 't';
//                }
//                if (stack.isEmpty()) {
//                    return result == 't' ? true : false;
//                } else {
//                    stack.push(result);
//                }
//            } else if (c != ',') {
//                stack.push(c);
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Solution1106 solution = new Solution1106();
        String expression = "|(f,t)";
        System.out.println(solution.parseBoolExpr(expression));
    }
}

package com.leetcode.other.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 替换字符串中的括号内容
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-12 11:31:00
 */
public class Solution1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> hash = new HashMap<>();
        for (List<String> strings : knowledge) {
            hash.put(strings.get(0), strings.get(1));
        }
        char[] chars = s.toCharArray();
        StringBuilder replaceStr = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean isStart = false;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!isStart && aChar != '(') {
                result.append(aChar);
            } else if (isStart && aChar != ')') {
                replaceStr.append(aChar);
            } else if (aChar == '(') {
                isStart = true;
            } else {
                isStart = false;
                String key = replaceStr.toString();
                result.append(hash.getOrDefault(key, "?"));
                replaceStr.setLength(0);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution1807 solution = new Solution1807();
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new LinkedList<>();
        knowledge.add(subList("name", "bob"));
        knowledge.add(subList("age", "two"));
        System.out.println(solution.evaluate(s, knowledge));
    }

    private static List<String> subList(String key, String value) {
        List<String> subList = new ArrayList<>(2);
        subList.add(key);
        subList.add(value);
        return subList;
    }
}

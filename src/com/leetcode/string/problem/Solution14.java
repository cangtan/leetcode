package com.leetcode.string.problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 最长公共前缀
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-06 13:39:00
 */
public class Solution14 {
    public String longestCommonPrefix2(String[] strs) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        Character current = null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(strs));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String poll = queue.poll();
                size--;
                if (index >= poll.length()) {
                    return result.toString();
                }
                char c = poll.charAt(index);
                if (current == null) {
                    current = c;
                } else if (current != c){
                    return result.toString();
                }
                queue.add(poll);
            }
            index++;
            result.append(current);
            current = null;
        }
        return result.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}

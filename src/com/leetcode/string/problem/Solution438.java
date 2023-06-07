package com.leetcode.string.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * @author 薛佳豪
 * @version V1.0
 * @since 2023-06-07 14:42:00
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        StringBuilder raw = new StringBuilder();
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }
        for (int j : count) {
            raw.append(j);
        }
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] bucket = new int[26];
            int start = i;
            int point = i + p.length();
            while (start < point) {
                bucket[s.charAt(start) - 'a']++;
                start++;
            }
            StringBuilder x = new StringBuilder();
            for (int total : bucket) {
                x.append(total);
            }
            if (x.toString().equals(raw.toString())) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution438 solution = new Solution438();
        String s = "abab";
        String p = "ab";
        System.out.println(solution.findAnagrams(s, p));
    }
}

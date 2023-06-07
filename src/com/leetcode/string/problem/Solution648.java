package com.leetcode.string.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词替换
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-07 17:33:00
 */
public class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] strs = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dictionary);
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (dictSet.contains(str.substring(0, 1 + j))) {
                    strs[i] = str.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", strs);
    }

    public static void main(String[] args) {
        Solution648 solution = new Solution648();
        String[] strs = {"cat", "bat", "rat"};
        List<String> dictionary = Arrays.asList(strs);
        String sentence = "the cattle was rattled by the battery";
        System.out.println(solution.replaceWords(dictionary, sentence));
    }
}

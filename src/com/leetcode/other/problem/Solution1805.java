package com.leetcode.other.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中不同整数的数目
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/number-of-different-integers-in-a-string/">字符串中不同整数的数目</a>
 * @since 2022-12-06 11:37:00
 */
public class Solution1805 {

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char aChar = word.charAt(i);
            if (aChar <= '9') {
                int j = i;
                while (j < word.length() && word.charAt(j) <= '9') j++;
                while (i < j && word.charAt(i) == '0') i++;
                set.add(word.substring(i, j));
                i = j;
            }
        }
        return set.size();
    }

//    public int numDifferentIntegers(String word) {
//        Set<String> set = new HashSet<>();
//        boolean isBegin = false;
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < word.length(); i++) {
//            char aChar = word.charAt(i);
//            if ('0' <= aChar && aChar <= '9') {
//                if (!isBegin) {
//                    isBegin = true;
//                }
//                if (result.length() >= 1 && result.charAt(0) == '0') {
//                    result.setCharAt(0, aChar);
//                } else {
//                    result.append(aChar);
//                }
//            } else if (isBegin) {
//                isBegin = false;
//                set.add(result.toString());
//                result.setLength(0);
//            }
//        }
//        if (isBegin) {
//            set.add(result.toString());
//        }
//        return set.size();
//    }

    public static void main(String[] args) {
        Solution1805 solution = new Solution1805();
        String word = "a1b01c001";
        System.out.println(solution.numDifferentIntegers(word));
    }
}

package com.leetcode.other.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 判断句子是否为全字母句
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-12-13 10:04:00
 * @see <a href="https://leetcode.cn/problems/check-if-the-sentence-is-pangram/">判断句子是否为全字母句</a>
 */
public class Solution1823 {
    public boolean checkIfPangram(String sentence) {
        // 二进制储存
        int result = 0;
        for (int i = 0; i < sentence.length(); i++) {
            result |= 1 << (sentence.charAt(i) - 'a');
        }
        return result == (1 << 26) - 1;
    }

//    public boolean checkIfPangram(String sentence) {
//        // 数组
//        boolean[] arr = new boolean[26];
//        for (int i = 0; i < sentence.length(); i++) {
//            arr[sentence.charAt(i) - 'a'] = true;
//        }
//        for (boolean b : arr) {
//            if (!b) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        Solution1823 solution = new Solution1823();
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(solution.checkIfPangram(sentence));
    }
}

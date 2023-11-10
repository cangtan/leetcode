package com.leetcode.string.problem;

/**
 * 情感丰富的文字
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-25 09:10:00
 * @see <a href="https://leetcode.cn/problems/expressive-words/">情感丰富的文字</a>
 */
public class Solution809 {

    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (expand(s, word)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean expand(String s, String t) {
        // 官方题解 双指针
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            char ch = s.charAt(i);
            int cnti = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                ++cnti;
                ++i;
            }
            int cntj = 0;
            while (j < t.length() && t.charAt(j) == ch) {
                ++cntj;
                ++j;
            }
            if (cnti < cntj) {
                return false;
            }
            if (cnti != cntj && cnti < 3) {
                return false;
            }
        }
        return i == s.length() && j == t.length();
    }

//    public int expressiveWords(String s, String[] words) {
//        // 转为数组后指针遍历
//        int[] countArr = new int[s.length()];
//        char[] relative = new char[s.length()];
//        int index = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
//                countArr[index] += 1;
//            } else {
//                relative[index] = s.charAt(i);
//                countArr[index] += 1;
//                index++;
//            }
//        }
//        int result = 0;
//        for (String word : words) {
//            int subIndex = 0;
//            int i = 0;
//            boolean flag = true;
//            while (i < word.length()) {
//                if (relative[subIndex] != word.charAt(i)) {
//                    flag = false;
//                    break;
//                }
//                char ch = word.charAt(i);
//                int pointer = 0;
//                while (i< word.length() && word.charAt(i) == ch) {
//                    pointer++;
//                    i++;
//                }
//                if (countArr[subIndex] < pointer || (countArr[subIndex] < 3 && countArr[subIndex] != pointer)){
//                    flag = false;
//                }
//                subIndex++;
//            }
//            if (flag && subIndex == index) {
//                result++;
//            }
//        }
//        return result;
//    }

//    public int expressiveWords(String s, String[] words) {
//        // 将字符串都转为两个数组,一个保存字符相对位置关系,另一个保存计数,最后比较数组
//        int[] countArr = new int[s.length()];
//        char[] relative = new char[s.length()];
//        int index = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
//                countArr[index] += 1;
//            } else {
//                relative[index] = s.charAt(i);
//                countArr[index] += 1;
//                index++;
//            }
//        }
//        int result = 0;
//        for (String word : words) {
//
//            if (word.length() > s.length()) {
//                continue;
//            }
//            int[] subCountArr = new int[word.length()];
//            char[] subRelative = new char[word.length()];
//            int subIndex = 0;
//            for (int i = 0; i < word.length(); i++) {
//                if (i != word.length() - 1 && word.charAt(i) == word.charAt(i + 1)) {
//                    subCountArr[subIndex] += 1;
//                } else {
//                    subRelative[subIndex] = word.charAt(i);
//                    subCountArr[subIndex] += 1;
//                    subIndex++;
//                }
//            }
//            if (subIndex != index) {
//                continue;
//            }
//            boolean flag = false;
//            for (int i = 0; i < subIndex; i++) {
//                if (relative[i] != subRelative[i]) {
//                    flag = false;
//                    break;
//                }
//                if (countArr[i] < subCountArr[i]) {
//                    flag = false;
//                    break;
//                }
//                if (countArr[i] >= 3 ) {
//                    flag = true;
//                } else if (countArr[i] != subCountArr[i]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag) {
//                result++;
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution809 solution = new Solution809();
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(solution.expressiveWords(s, words));
    }
}

package com.leetcode.array.problem;

/**
 * 句子相似性
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-16 11:39:00
 */
public class Solution1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // 双指针, 依提得插入的句子只能出现在左侧/右侧其中一边,
        String[] str1Arr = sentence1.split(" ");
        String[] str2Arr = sentence2.split(" ");
        int i = 0;
        int j = 0;
        while (i < str1Arr.length && i < str2Arr.length && str1Arr[i].equals(str2Arr[i])) {
            i++;
        }
        while (j < str1Arr.length - i && j < str2Arr.length - i && str1Arr[str1Arr.length - 1 - j].equals(str2Arr[str2Arr.length - 1 - j])) {
            j++;
        }
        return (i + j) == Math.min(str1Arr.length, str2Arr.length);
    }

    public static void main(String[] args) {
        Solution1813 solution = new Solution1813();
        String sentence1 = "b b";
        String sentence2 = "b";
        System.out.println(solution.areSentencesSimilar(sentence1, sentence2));
    }
}

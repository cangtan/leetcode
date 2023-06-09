package com.leetcode.string.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * KMP 算法
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-09 11:44:00
 */
public class KMP {
    public static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - i];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static List<Integer> search(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        int[] lps = buildLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    occurrences.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0){
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return occurrences;
    }

    public static void main(String[] args) {
        Arrays.stream(KMP.buildLPS("1231")).forEach(System.out::println);
    }
}

package com.leetcode.other.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-12-16 13:54:00
 * @see <a href="https://leetcode.cn/problems/ransom-note/">赎金信</a>
 */
public class Solution383 {
    /**
     * 使用map去实现
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hash = new HashMap<>(magazine.length());
        char[] magazineChars = magazine.toCharArray();
        for (char magazineChar : magazineChars) {
            if (hash.containsKey(magazineChar)) {
                hash.put(magazineChar, hash.get(magazineChar) + 1);
            } else {
                hash.put(magazineChar, 1);
            }
        }
        char[] ransomNoteChars = ransomNote.toCharArray();
        for (char ransomNoteChar : ransomNoteChars) {
            if (!hash.containsKey(ransomNoteChar) || hash.get(ransomNoteChar) < 1) {
                return false;
            } else {
                hash.put(ransomNoteChar, hash.get(ransomNoteChar) - 1);
            }
        }
        return true;
    }

    /**
     * 使用数组去实现
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] bucket = new int[26];
        char[] magazineChars = magazine.toCharArray();
        for (char magazineChar : magazineChars) {
            int index = magazineChar - 'a';
            bucket[index] += 1;
        }
        char[] ransomNoteChars = ransomNote.toCharArray();
        for (char ransomNoteChar : ransomNoteChars) {
           int index = ransomNoteChar - 'a';
           if (bucket[index] < 1) {
              return false;
           } else {
               bucket[index] -= 1;
           }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution383 solution383 = new Solution383();
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(solution383.canConstruct2(ransomNote, magazine));
    }
}

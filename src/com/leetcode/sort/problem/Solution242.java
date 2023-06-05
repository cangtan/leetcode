package com.leetcode.sort.problem;

/**
 * 242. 有效的字母异位词
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-05 14:20:00
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            bucket[c - 'a']--;
            if (bucket[c - 'a'] < 0) {
                return false;
            }
        }
        for (int i : bucket) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] temp1 = s.toCharArray();
        char[] temp2 = t.toCharArray();
        int[] bucket1 = new int[26];
        int[] bucket2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket1[temp1[i] - 'a']++;
            bucket2[temp2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(bucket1[i] != bucket2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution242 solution = new Solution242();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }
}

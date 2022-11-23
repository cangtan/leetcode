package com.leetcode.array.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 匹配子序列的单词数
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-17 11:45:00
 * @see <a href="https://leetcode.cn/problems/number-of-matching-subsequences/submissions/">匹配子序列的单词数</a>
 */
public class Solution792 {
    //暴力破解
//    public int numMatchingSubseq(String s, String[] words) {
//        int count = 0;
//        for (String item : words) {
//            int j = 0;
//            int i = s.indexOf(item.charAt(j)) != -1 ? s.indexOf(item.charAt(j)) : 0;
//            while (i < s.length() && j < item.length()){
//                if (s.charAt(i) == item.charAt(j)) {
//                    j++;
//                }
//                i++;
//            }
//            if (j == item.length()) {
//                count++;
//            }
//        }
//        return count;
//    }


    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }


//    public int numMatchingSubseq(String s, String[] words) {
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            String a = s.charAt(i) + "";
//            set.add(a);
//            s(a, set, s, i + 1);
//        }
//        int result = 0;
//        for (String word : words) {
//            if (set.contains(word)) {
//                result++;
//            }
//        }
//        return result;
//    }

    private void s(String a, Set<String> set, String s, int i) {
        for (int j = i; j < s.length(); j++) {
            String s1 = a + s.charAt(j);
            set.add(s1);
            s(s1, set, s, j + 1);
        }
    }


    public static void main(String[] args) {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        Solution792 solution = new Solution792();
        System.out.println(solution.numMatchingSubseq(s, words));

    }

}

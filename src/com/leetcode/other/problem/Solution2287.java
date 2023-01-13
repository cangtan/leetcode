package com.leetcode.other.problem;

/**
 * 重排字符形成目标字符串
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-13 09:07:00
 */
public class Solution2287 {
//    public int rearrangeCharacters(String s, String target) {
//        int[] arr = new int[26];
//        for (char c : s.toCharArray()) {
//            arr[c - 'a']++;
//        }
//        Map<Character, Integer> hash = new HashMap<>();
//        int min = s.length();
//        for (char c : target.toCharArray()) {
//            hash.put(c, hash.getOrDefault(c, 0) + 1);
//        }
//        for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
//            if (entry.getValue() == 0) {
//                return 0;
//            }
//            int i = arr[entry.getKey() - 'a'] / entry.getValue();
//            min = Math.min(min, i);
//        }
//        return min;
//    }

    public int rearrangeCharacters(String s, String target) {
        // 数组的耗时小于hash表
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char c : s.toCharArray()) {
            cnt1[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            cnt2[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (cnt2[i] != 0) {
                ans = Math.min(ans, cnt1[i] / cnt2[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        Solution2287 solution = new Solution2287();
        String s = "ilovecodingonleetcode";
        String target = "code";
        System.out.println(solution.rearrangeCharacters(s, target));
    }
}

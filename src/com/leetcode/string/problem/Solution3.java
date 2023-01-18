package com.leetcode.string.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-18 14:07:00
 */
public class Solution3 {


    /**
     * 滑动窗口
     *
     * @author 官方题解
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

//    public int lengthOfLongestSubstring(String s) {
//    //这是我的
//        Set<Character> set = new HashSet<>();
//        int i = 0;
//        int j = 0;
//        char[] chars = s.toCharArray();
//        int max = 0;
//        while (j < chars.length) {
//            if (!set.contains(chars[j])) {
//                // 未出现重复则指针向前,并且添加到数组中
//                set.add(chars[j]);
//                j++;
//            } else {
//                int current = j - i;
//                max = Math.max(current, max);
//                // 出现了重复, 寻找重复字符
//                while (chars[i] != chars[j]) {
//                    set.remove(chars[i]);
//                    i++;
//                }
//                i++;
//                j++;
//            }
//
//        }
//        return Math.max(j - i, max);
//    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String s = "abcabcaa";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

package com.leetcode.dp.problem;

/**
 * 最长回文子串
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-13 14:11:00
 */
public class Solution5 {
    /**
     * 官方题解
     * 用P(i,j)表示字符串s的第i到j个字母组成的串(s[i:j])
     * P(i,j) => true 子串Si...Sj是回文串
     *        => false 其他情况 （i>j | S[i:j]本身不是一个回文串
     * 此时能得到动态规划的转移方程
     * P(i,j)=P(i+1,j-1)&(Si==Sj)
     * 当S[i+1:j-1]是回文串,并且S的第i和j个字符相同时，S[i:j]才会是回文串
     * 讨论是基于长度大于2的前提之上的,对于长度为1子串，它显然是个回文串,对于长度为2的子串，只要它的两个字母相同，它就是一个回文串
     * P(i, i) = true
     * P(i, i+1)=(Si==Si+1)
     * 最终答案即P(i,j)=true中j-i+1的最大值
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int l = 2; l <= len; l++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 l 和 i 可以确定右边界，即 j - i + 1 = l 得
                int j = l + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][l] == true 成立，就表示子串 s[i..l] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        String str = "ab";
        System.out.println(solution.longestPalindrome(str));
    }
}

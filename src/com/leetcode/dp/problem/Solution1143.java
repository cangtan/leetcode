package com.leetcode.dp.problem;

/**
 * 最长公共子序列
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-11 15:09:00
 */
public class Solution1143 {


    /**
     * 0 a b c d e
     * a 1 1 1 1 1
     * c 1 1 2 2 2
     * e 1 1 2 2 3
     * 将字符串转为二维数组
     * 假设字符串的长度text1和text2的长度分别为m和n，创建m+1行和n+1列的二维数组dp,其中 dp[i][j]表示text1[0:i]和text[0:j]的最长公共子序列的长度
     * 上述表示中, text1[0:i]表示text1的长度为i的前缀，text2[0:j]表示text2的长度为j的前缀
     * 考虑动态规划的边界情况:
     * 当 i = 0时，text1[0:i]为空，空字符串和任何字符串的最长公共子序列的长度都是0，因此对任意0<=j<=n，都有dp[0][j]=0;
     * 当 j = 0时，text2[0:j]为空，同理可得，对任意0<=i<=m，有dp[i][0]=0
     * 因此动态规划的边界情况是：当i=0或j=0时,dp[i][j]=0。
     * 当 i > 0 且 j > 0时，考虑dp[i][j]的计算：
     * 当text1[i - 1] = text2[j - 1]时，将这两个相同的字符称为公共字符,考虑text1[0:i-1]和text2[0:j-1]的最长公共子序列，再增加一个字符（即公共字符）
     * 即可得到text1[0:i]和text2[0:j]的最长公共子序列，因此dp[i][j]=dp[i-1][j-1]+1
     * 当text1[i-1]!=text2[j-1]时，考虑以下两项:
     * text1[0:i-1]和text2[0:j]的最长公共子序列
     * text1[0:i]和text2[0:j-1]的最长公共子序列
     * 要得到text1[0:i]和text2[0:j]的最长公共子序列,应取两项中的长度较大的一项,因此dp[i][j]=max(dp[i-j][j], dp[i][j-1])
     * 由此可以得到如下状态方程：
     * dp[i][j]={
     * dp[i-1][j-1]+1,text1[i-1]=text2[j-1]
     * max(dp[i-1][j],dp[i][j-1],text1[i-1]!=text2[j-1])
     * }
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char charI = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char charJ = text2.charAt(j - 1);
                if (charI == charJ) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

//    public int longestCommonSubsequenceForce(String text1, String text2) {
//        if (text1.length() < text2.length()) {
//            String temp = text1;
//            text1 = text2;
//            text2 = temp;
//        }
//        int[][] dp = new int[text1.length()][text2.length()];
//        int result = 0;
//        for (int i = 0; i < text2.length(); i++) {
//            result = Math.max(longestCommonSubsequenceHelper(text1.toCharArray(), text2.toCharArray(), 0, i, dp), result);
//        }
//        return result;
//    }
//
//    public int longestCommonSubsequenceHelper(char[] arr1, char[] arr2, int a1, int a2, int[][] dp) {
//        if (a1 >= arr1.length || a2 >= arr2.length) {
//            return 0;
//        }
//        int result = 0;
//        for (int i = a1; i < arr1.length; i++) {
//            if (arr2[a2] == arr1[i]) {
//                for (int j = a2; j < arr2.length; j++) {
//                    if (i + 1 < arr1.length && j + 1 < arr2.length && dp[i + 1][j + 1] != 0) {
//                        result = Math.max(dp[i + 1][j + 1] + 1, result);
//                    } else {
//                        result = Math.max(longestCommonSubsequenceHelper(arr1, arr2, i + 1, j + 1, dp) + 1, result);
//                    }
//                }
//                dp[i][a2] = result;
//                break;
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution1143 solution = new Solution1143();
        String text1 = "hofubmnylkra";
        String text2 = "pqhgxgdofcvmr";


        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
}

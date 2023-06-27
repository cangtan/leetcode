package com.leetcode.dp.problem;

/**
 * 删除一次得到子数组最大和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-27 13:50:00
 */
public class Solution1186 {
    public int maximumSum(int[] arr) {
        // dp[i][0] = max(dp[i-1][0],0) + arr[i]
        // 在不删除的情况下,以arr[i]为结尾的非空子数组的最大和dp[i][0]与dp[i-1][0]有关,当dp[i-1][0]>0时，直接将arr[i]与i-1时的最大非空子数组连接时，
//        取得最大和，否则只选arr[i]时，取得最大和
        // dp[i][1]=max(dp[i-1][1]+arr[i],dp[i-1][0])
        // 表示在删除一次的情况下，以arr[i]为结尾的非空子数组有两种情况
        // 不删除arr[i]，那么选择arr[i]与dp[i-1][1]对应的子数组（已执行过一次删除）
        // 删除arr[i]，那么选择dp[i-1][0]对应的非空子数组（未执行一次删除，但是等同于删除了arr[i]）
        int dp0 = arr[0], dp1 = 0, res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0, 0) + arr[i];
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1186 solution = new Solution1186();
        int[] arr = {-1,-1,-1,-1};
        System.out.println(solution.maximumSum(arr));
    }
}

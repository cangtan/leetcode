package com.leetcode.recursion.problem;

/**
 * 爬楼梯
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/climbing-stairs/submissions/">爬楼梯</a>
 * @since 2022-11-28 14:32:00
 */
public class Solution70 {

    public int climbStairs(int n) {
        // 为了避免递归超时，对结果进行缓存
        // 数组缓存后发现只需要对前两位进行缓存
        int prev1 = 1;
        int prev2 = 2;
        if (n == 1) {
            return prev1;
        }
        if (n == 2) {
            return prev2;
        }
        for (int i = 3; i <= n; i++) {
            int temp = prev2;
            prev2 = prev1 + prev2;
            prev1 = temp;
        }
        return prev2;
    }

//    public int climbStairs(int n) {
//        // 斐波那切数列 F(n) = F(n-1) + F(n-2)
//        // 递归 -> 超时
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

    public static void main(String[] args) {
        int n = 4;
        Solution70 solution = new Solution70();
        System.out.println(solution.climbStairs(n));
    }
}

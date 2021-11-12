package com.leetcode.array.problem;

import javax.xml.transform.Result;

/**
 * climbing stairs
 * @version V1.0
 * @author cangtan
 * @date 2021-3-1 16:55
 * @link https://leetcode.com/problems/climbing-stairs/
 * 这题思路我是卡在了没有想到下一阶梯的方案是前两阶梯方案数之和
 * 斐波那契数列
 * 可以用一个数组去做缓存，但是缓存后发现，其实只需要缓存前两个值
 */
public class Solution70 {
    public int climbStairs(int n) {
        int result = 0;
        int cache1 = 1;
        int cache2 = 2;
        if (n == 1) {
            return cache1;
        }
        if (n == 2) {
            return cache2;
        }
        for (int i = 3; i <= n; i++) {
            result = cache1 + cache2;
            cache1 = cache2;
            cache2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        Solution70 solution = new Solution70();
        System.out.println(solution.climbStairs(n));
    }
}

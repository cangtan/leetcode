package com.leetcode.bitwise.problem;

/**
 * 颠倒二进制位
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-17 14:14:00
 */
public class Solution190 {
    public int reverseBitsApi(int n) {
        // 看源码
        return Integer.reverse(n);
    }

    public int reverseBits(int n) {
        int length = 31;
        int result = 0;
        while (length >= 0) {
            result += (n & 1) << length;
            n >>=  1;
            length--;
        }
        return result;
    }

    public int reverseBits2(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution190 solution = new Solution190();
        System.out.println(solution.reverseBits(43261596));
    }
}

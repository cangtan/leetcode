package com.leetcode.math.problem;

/**
 * 检查好数组 - 裴蜀定理
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-15 09:23:00
 */
public class Solution1250 {
    /**
     * 裴蜀定理
     * 若a,b是整数,且gcd(a,b)=d，那么对于任意的整数x,y,ax+by都一定是d的倍数，
     * 特别地，一定存在整数x,y，使ax+by=d成立。
     * a,b互质的充要条件是存在整数x,y使ax+by=1.
     */
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(num, divisor);
            if (divisor == 1) {
                break;
            }
        }
        return divisor == 1;
    }

    /**
     * 欧几里得算法（辗转相除法）
     * 计算两个非负整数a，b的最大公约数
     * gcd(a,b) = gcd(b, a mod b)
     */
    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }

    public static void main(String[] args) {
        Solution1250 solution = new Solution1250();
        int[] nums = {12, 5, 7, 23};
        System.out.println(solution.isGoodArray(nums));
    }
}

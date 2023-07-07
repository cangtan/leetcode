package com.leetcode.string.problem;

/**
 * 回文数
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-07 16:34:00
 */
public class Solution9 {

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        // 反转数字本身，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文
        // 但是要注意的是反转可能导致的溢出问题, 因此可以考虑只反转一半数字
        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，可以通过revertNumber/10去除处于中位数的数字
        // 中位的数字不影响回文（它总是与自己相等），我们可以简单地将其去除
        return x == revertNumber || x == revertNumber / 10;
    }

    /**
     * 转字符串,需要额外空间
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        int x = 1221;
        System.out.println(solution.isPalindrome(x));
    }
}

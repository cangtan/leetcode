package com.leetcode.other.problem;

/**
 * 判断一个数的数字计数是否等于位数的值
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-11 09:40:00
 */
public class Solution2283 {
    public boolean digitCount(String num) {
        int[] arr = new int[10];
        char[] chars = num.toCharArray();
        for (char aChar : chars) {
            int i = aChar - '0';
            arr[i]++;
        }
        for (int i = 0; i < chars.length; i++) {
            int number = chars[i] - '0';
            if (arr[i] != number) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2283 solution = new Solution2283();
        String num = "030";
        System.out.println(solution.digitCount(num));
    }
}

package com.leetcode.other.problem;

/**
 * 字符串相加
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-17 15:27:00
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int add = 0;
        StringBuilder result = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || add != 0) {
            int i = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int j = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int temp = i + j + add;
            result.append(temp % 10);
            add = temp / 10;
            len1--;
            len2--;
        }
        return result.reverse().toString();
    }

    /**
     * 正向做题了
     */
    public String addStrings2(String num1, String num2) {
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder result = new StringBuilder("0");
        while (len1 >= 0 || len2 >= 0) {
            int i = len1 >= 0 ? num1Arr[len1] - '0' : 0;
            int j = len2 >= 0 ? num2Arr[len2] - '0' : 0;
            int k = result.charAt(0) - '0';
            int temp = i + k + j;
            result.replace(0, 1, String.valueOf(temp % 10));
            result.insert(0, String.valueOf(temp / 10));
            len1--;
            len2--;
        }
        if (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution415 solution = new Solution415();
        String num1 = "123";
        String num2 = "911";
        System.out.println(solution.addStrings(num1, num2));
    }
}

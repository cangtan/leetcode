package com.leetcode.string.problem;

/**
 * 67. 二进制求和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-09-12 14:46:00
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        boolean bin = false;
        for (int i = 0; i < a.length(); i++) {
            int x = b.length() - i > 0 ? b.charAt(b.length() - 1 - i) - '0' : 0;
            int y = a.charAt(a.length() - 1 - i) - '0';
            int unit = x + y;
            if (bin) {
                unit += 1;
            }
            if (unit >= 2) {
                stringBuilder.append(unit % 2);
                bin = true;
            } else {
                stringBuilder.append(unit);
                bin = false;
            }
        }
        if (bin) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution67 solution = new Solution67();
        String a = "1101";
        String b = "101";
        System.out.println(solution.addBinary(a, b));
    }
}

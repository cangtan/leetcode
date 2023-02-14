package com.leetcode.string.problem;

/**
 * 替换子串得到平衡字符串
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-13 14:28:00
 */
public class Solution1234 {
    public int balancedString(String s) {
        int[] cnt = new int[26];
        int length = s.length();
        int res = length;
        for (int i = 0; i < length; i++) {
            cnt[s.charAt(i) - 'A']++;
        }
        if (check(cnt, length)) {
            return 0;
        }
        int r = 0;
        for (int l = 0; l < length; l++) {
            while (r < length && !check(cnt, length)) {
                cnt[s.charAt(r) - 'A']--;
                r++;
            }
            if (!check(cnt, length)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[s.charAt(l) - 'A']++;
        }
        return res;
    }

    public boolean check(int[] cnt, int length) {
        int partial = length / 4;
        return cnt['Q' - 'A'] <= partial
                && cnt['W' - 'A'] <= partial
                && cnt['E' - 'A'] <= partial
                && cnt['R' - 'A'] <= partial;
    }

    public static void main(String[] args) {
        Solution1234 solution = new Solution1234();
        String str = "QQWE";
        System.out.println(solution.balancedString(str));
    }
}

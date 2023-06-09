package com.leetcode.string.example;

/**
 * 拉宾卡普算法
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-09 10:05:00
 */
public class RabinKarpSearch {
    /**
     * 因为字符，字符为0~256,将字符当做256进制，相当于前一位为*256+当前位
     */
    public static final int D = 256;
    /**
     * 为了避免hash超出限制，选取一个质数用来缩减
     */
    public static final int Q = 9997;

    public static int search(String txt, String pat) {
        int m = pat.length();
        int n = txt.length();
        int i;
        int j;
        int patHash = 0;
        int txtHash = 0;
        for (i = 0; i < m; i++) {
            patHash = (D * patHash + pat.charAt(i)) % Q;
            txtHash = (D * txtHash + txt.charAt(i)) % Q;
        }

        int highestPow = 1;
        // 类pow(256, M-1) 求出最高位的权重值
        for (i = 0; i < m - 1; i++) {
            highestPow = (highestPow * D) % Q;
        }

        for (i = 0; i <= n - m; i++) {
            if (patHash == txtHash) {
                // hash值相等，一位一位比较，不相等则退出循环，相等则返回
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    return i;
                }
            }
            if (i < n - m) {
                // 滑动窗口，挪动窗口，减去高位，加上当前位求出hash
                txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + m)) % Q;
                if (txtHash < 0) {
                    txtHash += Q;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(RabinKarpSearch.search("91nasgoasd0g901", "0g"));
    }
}

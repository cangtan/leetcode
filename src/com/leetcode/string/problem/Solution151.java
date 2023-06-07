package com.leetcode.string.problem;

/**
 * 151. 反转字符串中的单词
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-06 16:01:00
 */
public class Solution151 {
    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int left = 0;
        while (left < n && chars[left] == ' ') {
            left++;
        }
        int right = n - 1;
        while (right > 0 && chars[right] == ' ') {
            right--;
        }
        swap(chars, left, right);
        int tempLeft = -1;
        for (int i = left; i <= right; i++) {
            if (chars[i] == ' ' && chars[i] == chars[i - 1]) {
                continue;
            } else if (chars[i] == ' ') {
                swap(chars, tempLeft, i - 1);
                tempLeft = -1;
            } else if (tempLeft != -1 && i == right) {
                swap(chars, tempLeft, right);
            } else {
                if (tempLeft == -1) {
                    tempLeft = i;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(chars));
        int index = 0;
        while (index < n) {
            if (index < left) {
                stringBuilder.deleteCharAt(index);
                right--;
                n--;
                left--;
            } else if (index > right) {
                stringBuilder.deleteCharAt(index);
                n--;
            } else if (stringBuilder.charAt(index) == ' ' && stringBuilder.charAt(index - 1) == ' ') {
                stringBuilder.deleteCharAt(index);
                right--;
                n--;
            } else {
                index++;
            }
        }
        return stringBuilder.toString();
    }

    private void swap(char[] chars, int left, int right) {
        int p1 = left;
        int p2 = right;
        while (p1 < p2) {
            char temp = chars[p1];
            chars[p1] = chars[p2];
            chars[p2] = temp;
            p1++;
            p2--;
        }
    }

    /**
     * 官方题解
     *
     * @author LeetCode-Solution
     * @see <a href="https://leetcode.cn/problems/reverse-words-in-a-string/solution/fan-zhuan-zi-fu-chuan-li-de-dan-ci-by-leetcode-sol/">官方题解</a>
     */
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }


    public static void main(String[] args) {
        Solution151 solution = new Solution151();
        String s = "a good   example";
        System.out.println(solution.reverseWords(s));
    }
}

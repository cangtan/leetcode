package com.leetcode.hash.problem;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 解密消息
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-02-01 09:41:00
 */
public class Solution2325 {


    public String decodeMessage(String key, String message) {
        int[] a = new int[26];
        Arrays.fill(a, -1);
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char aChar = key.charAt(i);
            int point = aChar - 'a';
            if (aChar >= 'a' && aChar <='z' && a[point] == -1 ) {
                a[point] = index;
                index++;
            }
        }
        char[] chars = message.toCharArray();
        for (int i = 0; i < message.length(); i++) {
            char aChar = chars[i];
            if ('a' <= aChar && aChar <= 'z') {
                chars[i] = ((char)('a' + a[aChar - 'a']));
            }
        }
        return new String(chars);
    }

//    public String decodeMessage(String key, String message) {
//        // hash
//        StringBuilder stringBuilder = new StringBuilder();
//        Map<Character, Integer> decodeMap = new HashMap<>();
//        int index = 0;
//        for (int i = 0; i < key.length(); i++) {
//            char aChar = key.charAt(i);
//            if (!decodeMap.containsKey(aChar) && aChar >= 'a' && aChar <='z') {
//                decodeMap.put(aChar, index);
//                index++;
//            }
//        }
//        for (int i = 0; i < message.length(); i++) {
//            char aChar = message.charAt(i);
//            if ('a' <= aChar && aChar <= 'z') {
//                stringBuilder.append((char)('a' + decodeMap.get(aChar)));
//            } else {
//                stringBuilder.append(aChar);
//            }
//
//        }
//        return stringBuilder.toString();
//    }

    public static void main(String[] args) {
        Solution2325 solution = new Solution2325();
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(solution.decodeMessage(key, message));
    }
}

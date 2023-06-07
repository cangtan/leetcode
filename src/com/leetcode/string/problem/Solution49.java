package com.leetcode.string.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-07 11:27:00
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime = new int[26];
        int count = 0;
        int number = 2;
        while (count < 26) {
            int sqrt = (int) Math.sqrt(number);
            boolean isPrime = true;
            for (int i = 2; i <= sqrt; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                prime[count++] = number;
            }
            number++;
        }
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            long hashCode = 1;
            for (char aChar : chars) {
                int i = prime[aChar - 'a'];
                hashCode *= i;
                hashCode %= Integer.MAX_VALUE;
            }
            if (map.containsKey(hashCode)) {
                map.get(hashCode).add(str);
            } else {
                List<String> item = new LinkedList<>();
                item.add(str);
                map.put(hashCode, item);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution49 solution = new Solution49();
        String[] strs = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        System.out.println(solution.groupAnagrams2(strs));
    }
}

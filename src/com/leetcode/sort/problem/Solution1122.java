package com.leetcode.sort.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组的相对排序
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-05 11:23:00
 */
public class Solution1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int index = 0;
        int[] result = new int[arr1.length];
        for (int i : arr1) {
            bucket[i]++;
        }
        for (int i : arr2) {
            while (bucket[i] > 0) {
                result[index++] = i;
                bucket[i]--;
            }
        }
        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i] > 0) {
                while (bucket[i] > 0) {
                    result[index++] = i;
                    bucket[i]--;
                }
            }
        }
        return result;
    }

    /**
     * 一个不太聪明的做法
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] bucket = new int[arr2.length];
        int[] arr1Copy = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        int len = 0;
        for (int j : arr1) {
            if (!map.containsKey(j)) {
                arr1Copy[len++] = j;
            } else {
                bucket[map.get(j)]++;
            }
        }
        int resultLen = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                result[resultLen] = arr2[i];
                bucket[i]--;
                resultLen++;
            }
        }
        Arrays.sort(arr1Copy);
        int index = 0;
        while (resultLen < arr1.length) {
            result[resultLen++] = arr1Copy[arr1.length - len + index];
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1122 solution = new Solution1122();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] result = solution.relativeSortArray(arr1, arr2);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

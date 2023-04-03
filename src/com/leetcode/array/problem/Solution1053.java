package com.leetcode.array.problem;

import java.util.Arrays;

/**
 * 交换一次的先前排列
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-03 10:55:00
 */
public class Solution1053 {
    /**
     * 贪心
     */
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        // i 需要保持最大
        for (int i = n - 2; i >= 0; i--) {
            // 判断右侧是否存在比自己小的数
            if (arr[i] > arr[i + 1]) {
                int j = n - 1;
                // 当右侧有比自己小的数时，找最大值
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                break;
            }
        }
        return arr;
    }

    /**
     * 暴力解法，可以通过
     * 耗时1482ms
     */
//    public int[] prevPermOpt1(int[] arr) {
//        int resultI = 0;
//        int resultJ = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            int maxValue = 0;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[i] && arr[j] != maxValue) {
//                    maxValue = Math.max(maxValue, arr[j]);
//                    resultJ = j;
//                }
//            }
//            if (maxValue != 0) {
//                resultI = i;
//            }
//        }
//        if (resultI < resultJ) {
//            int temp = arr[resultJ];
//            arr[resultJ] = arr[resultI];
//            arr[resultI] = temp;
//        }
//        return arr;
//    }
    public static void main(String[] args) {
        Solution1053 solution = new Solution1053();
        int[] arr = {3, 1, 1, 3};
        int[] result = solution.prevPermOpt1(arr);
        Arrays.stream(result).forEach(System.out::println);
    }
}

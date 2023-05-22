package com.leetcode.sort.example;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-22 14:39:00
 */
public class BubbleSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {4,1,2,9,10,20,31,2154,29};
        bubbleSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

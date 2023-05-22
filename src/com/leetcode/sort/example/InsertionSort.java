package com.leetcode.sort.example;

import java.util.Arrays;

/**
 * 插入排序
 * 从前到后逐步构建有序序列
 * 对于为排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-22 14:23:00
 */
public class InsertionSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,9,10,20,31,2154,29};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

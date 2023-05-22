package com.leetcode.sort.example;

import java.util.Arrays;

/**
 * 选择排序
 * 每次找到最小值，然后放到待排序数组的起始位置
 * O(n^2)
 * @author cangtan
 * @version V1.0
 * @since 2023-05-22 14:18:00
 */
public class SelectionSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {4,1,2,9,10,20,31,2154,29};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

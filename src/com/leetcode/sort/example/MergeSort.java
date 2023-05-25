package com.leetcode.sort.example;

import java.util.Arrays;

/**
 * 归并排序
 * 1.把长度为n的输入序列分为两个长度为n/2的子序列
 * 2.对这两个子序列分别采用归并排序
 * 3.将两个排序好的子序列合并成一个最终的排序序列
 *
 * @author cantan
 * @version V1.0
 * @since 2023-05-22 15:10:00
 */
public class MergeSort {
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        // 中间数组
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {1, 0, -1, 20, 203, 2141, 24, 29, 1, 0, 10, 102, 3};
        mergeSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

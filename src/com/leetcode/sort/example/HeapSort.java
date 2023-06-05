package com.leetcode.sort.example;

/**
 * 堆排序
 * 堆插入O(nlogn),取最大最小值O(1)
 * 数组元素依次建立小顶堆
 * 依次取堆顶元素并删除
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-05-25 17:46:00
 */
public class HeapSort {
    public void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, length, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 23, 20, 286, 2, 0, 3, 4, 8, 20};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

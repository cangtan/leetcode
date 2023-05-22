package com.leetcode.sort.example;

/**
 * 快速排序，选取基数，从两头向数组中心进行比较与交换，
 * 找到基数的排序位置，以该位置将数组划分为两部分，两部分再选出基数，以此递归。
 * <p>
 * 数组选取标杆pivot, 将小元素放pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排，已达到整个序列有序
 *
 * @author ives
 * @version V1.0
 * @date 2020-3-31 11:19
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = getIndex(array, low, high);
            //对基数左半边继续排序
            quickSort(array, low, index - 1);
            //对基数右半边继续排序
            quickSort(array, index + 1, high);
        }
        return array;
    }

    public static int getIndex(int[] array, int low, int high) {
        //选取一个基数（基数的选取可以进行相对应的优化）
        int pivot = array[low];
        while (low < high) {
            //进行比较，找出高位低于基数的数
            while (low < high && array[high] >= pivot) {
                high--;
            }
            //将低于基数的数赋值到低位
            array[low] = array[high];
            //进行比较，找出低位大于基数的数，进行交换
            while (low < high && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }
        //最后基数将会在数组中正确的位置，以该位置将数组分为两部分
        array[low] = pivot;
        return low;
    }

    public static int getIndex2(int[] array, int low, int high) {
        int pivot = high;
        int counter = low;
        for (int i = low; i < high; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }
}

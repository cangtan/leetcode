package com.leetcode.search.binary;

/**
 * 搜索二维矩阵
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-10 16:52:00
 */
public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            // 找到第一个比 target小的数
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        if (right < 0) {
            return false;
        }
        int line = right;
        left = 0;
        right = matrix[line].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[line][mid] == target) {
                return true;
            } else if (matrix[line][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution74 solution = new Solution74();
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };
//        int target = 11;
        int[][] matrix = {
                {1},
        };
        int target = 0;
        System.out.println(solution.searchMatrix(matrix, target));
    }
}

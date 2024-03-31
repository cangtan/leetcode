package com.leetcode.array.problem;

public class Solution915 {
    public static void main(String[] args) {
        Solution915 solution = new Solution915();
        int[] nums = {5, 0, 3, 8, 6};
        System.out.println(solution.partitionDisjoint(nums));
    }

    /**
     * 二次遍历
     */
    public int partitionDisjoint2(int[] nums) {
        int[] minRightArr = new int[nums.length];
        int n = nums.length;
        minRightArr[n - 1] = nums[n - 1];
        // 填充右边最小值
        for (int r = n - 2; r >= 0; r--) {
            minRightArr[r] = Math.min(nums[r], minRightArr[r + 1]);
        }
        int maxLeft = nums[0];
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if (maxLeft <= minRightArr[i + 1]) {
                return i + 1;
            }

        }
        return n;
    }

    /**
     * 一次遍历
     */
    public int partitionDisjoint(int[] a) {
        int max = a[0];
        int leftPartitionMax = a[0];
        int partitionIdx = 0;

        //left[max] < right[min]

        for (int i = 1; i < a.length; i++){
            //left part
            if (leftPartitionMax > a[i]) {
                leftPartitionMax = max;
                partitionIdx = i;
            }
            max = Math.max(max, a[i]);
        }

        return partitionIdx + 1;
    }
}

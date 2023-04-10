package com.leetcode.search.binary;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-10 16:23:00
 */
public class Solution153 {
    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    public int findMinHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (nums[left] < nums[right]) {
            // 规则
            return nums[left];
        } else {
            int mid = (left + right) / 2;
            return Math.min(findMinHelper(nums, left, mid), findMinHelper(nums, mid + 1, right));
        }
    }

    /**
     * 官方题解
     * @author leetcode
     * @see <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-5irwp/">寻找旋转排序数组中的最小值</a>
     */
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        Solution153 solution = new Solution153();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(solution.findMin(nums));
    }
}

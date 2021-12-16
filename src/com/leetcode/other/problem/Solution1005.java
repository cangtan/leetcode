package com.leetcode.other.problem;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * K 次取反后最大化的数组和
 *
 * @author cangtan
 * @version V1.0
 * @date 2021-12-15 11:43:00
 * @link
 */
public class Solution1005 {

    /**
     * 找出最接近0的值的下标,当负数全部转正后进行反转
     * 写得还是有点憨了
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int minIndex = -1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k <= 0) {
                break;
            }
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            } else {
                if (nums[i] > 0 && i != 0) {
                    minIndex = nums[i] < nums[i - 1] ? i : i - 1;
                } else {
                    minIndex = i;
                }
            }
            if (minIndex != -1) {
                break;
            }
        }
        if (minIndex == -1) {
            nums[nums.length - 1] = nums[nums.length - 1] * (int) (Math.pow(-1d, k));
        } else {
            nums[minIndex] = nums[minIndex] * (int) (Math.pow(-1d, k));
        }
        for (int num : nums) {
            result += num;
        }
        return result;
    }

    /**
     * 先反转了负数，然后再次利用排序，减去最小值
     *
     * @author Yipsen
     */
    public int largestSumAfterKNegations2(int[] nums, int k) {
        // 排序，把可能有的负数排到前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心：如果是负数，而k还有盈余，就把负数反过来
            if (nums[i] < 0 && k > 0) {
                nums[i] = -1 * nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        // 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。
        return sum - (k % 2 == 0 ? 0 : 2 * nums[0]);
    }

    /**
     * 利用了PriorityQueue
     *
     * @author ebou
     * @link https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/discuss/252228/A-very-simple-java-solution
     * 很巧妙，但是提交了下耗时5ms
     */
    public int largestSumAfterKNegations3(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : nums) {
            pq.add(x);
        }
        while (k-- > 0) {
            pq.add(-pq.poll());
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += pq.poll();
        }
        return sum;
    }

    /**
     * 对自己之前的做法做了一个调整
     */
    public int largestSumAfterKNegations4(int[] nums, int k) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            result += nums[i];
            min = Math.min(min, nums[i]);
        }
        return result - (k % 2 * min * 2);
    }

    public static void main(String[] args) {
        Solution1005 solution = new Solution1005();
        int[] nums = {2, -3, -1, 5, -4};
        int k = 2;
        System.out.println(solution.largestSumAfterKNegations4(nums, k));
    }
}

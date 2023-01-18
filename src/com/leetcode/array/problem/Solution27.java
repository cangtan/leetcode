package com.leetcode.array.problem;

import java.util.Arrays;

/**
 * 移除元素
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-01-18 15:41:00
 */
public class Solution27 {

    /**
     * 双指针
     *
     * @author 官方题解
     * @see <a href="https://leetcode.cn/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode-solution-svxi/">官方题解</a>
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length ;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

//    public int removeElement(int[] nums, int val) {
//        // 我丑陋的代码
//        int result = nums.length;
//        int i = nums.length - 1;
//        int j = nums.length - 1;
//        while (i >= 0) {
//            if (nums[i] != val) {
//                while (j >= 0 && nums[j] != val) {
//                    j--;
//                }
//                if (j == -1) {
//                    break;
//                } else {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                    j--;
//                    i--;
//                    result--;
//                }
//            } else {
//                result--;
//                i--;
//                j = i;
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        int[] nums = {3,2,2,3};
        int val = 1;
        System.out.println(solution.removeElement(nums, val));
        Arrays.stream(nums).forEach(System.out::println);
    }
}

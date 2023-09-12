package com.leetcode.other.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复的元素
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-09-12 11:26:00
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        int temp;

        if (nums.length == 1 || nums.length == 0) return false; // 没有重复元素

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                // 比队尾最大元素小，与其他已访问元素进行对比，判断是否重复
                for (int j = i - 2; j >= 0; j--) {
                    if (nums[j] == nums[i]) return true;
                }
                // 把已访问过的元素中最大值放到队尾
                temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
            } else if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
    /**
     * 借助api
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

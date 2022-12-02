package com.leetcode.recursion.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 全排列
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/permutations/">全排列</a>
 * @since 2022-12-01 17:55:00
 */
public class Solution46 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> item = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        permuteHelper(nums);
        return result;
    }

    public void permuteHelper(int[] nums) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int num : nums) {
            if (!item.contains(num)) {
                item.add(num);
                permuteHelper(nums);
                item.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        int[] nums = {1, 2, 3};
        System.out.println(solution.permute(nums));
    }
}

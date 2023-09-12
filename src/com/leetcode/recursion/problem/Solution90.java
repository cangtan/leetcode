package com.leetcode.recursion.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集II
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-06-29 09:10:00
 */
public class Solution90 {

    List<Integer> item = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choose, int index, int[] nums) {
        if (index >= nums.length) {
            ans.add(new ArrayList<>(item));
            return;
        }
        dfs(false, index + 1, nums);
        if (!choose && index > 0 && nums[index - 1] == nums[index]) {
            // 前一位不选 且等于前一位
            return;
        }
        item.add(nums[index]);
        dfs(true, index + 1, nums);
        item.remove(item.size() - 1);
    }

    public static void main(String[] args) {
        Solution90 solution = new Solution90();
        int[] nums = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
    }
}

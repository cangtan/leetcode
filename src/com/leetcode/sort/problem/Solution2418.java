package com.leetcode.sort.problem;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2418. 按身高排序
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/sort-the-people/">按身高排序</a>
 * @since 2022-11-01 14:20:00
 */
public class Solution2418 {

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], i);
        }
        Arrays.sort(heights);
        String[] result = new String[names.length];
        int index = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            result[index++] = names[map.get(heights[i])];
        }
        return result;
    }

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        Solution2418 solution = new Solution2418();
        String[] strings = solution.sortPeople(names, heights);
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println();
    }
}

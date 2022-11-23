package com.leetcode.other.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 盒子中小球的最大数量
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-11-23 15:53:00
 */
public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
//        hash表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit ; i++) {
            int count = count(i);
            if (map.containsKey(count)) {
                map.put(count, map.get(count) + 1);
            } else{
                map.put(count, 1);
            }
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result = Math.max(result, entry.getValue());
        }
        return result;
    }

    public int count(int nums) {
        int result = 0;
        while (nums > 0) {
            result += nums % 10;
            nums /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1742 solution = new Solution1742();
        int lowLimit = 1;
        int highLimit = 10;
        System.out.println(solution.countBalls(lowLimit, highLimit));
    }
}

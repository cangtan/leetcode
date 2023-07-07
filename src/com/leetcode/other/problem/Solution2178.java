package com.leetcode.other.problem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 拆分成最多数目的正偶数之和
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-07-06 09:59:00
 */
public class Solution2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        // 贪心
        if ((finalSum & 1) != 0) {
            return Collections.emptyList();
        }
        LinkedList<Long> result = new LinkedList<>();
        for (long i = 2; i <= finalSum; i += 2) {
            result.add(i);
            finalSum -= i;
        }
        result.set(result.size() - 1, result.get(result.size() - 1) + finalSum);
        return result;
    }

    public static void main(String[] args) {
        Solution2178 solution = new Solution2178();
        System.out.println(solution.maximumEvenSplit(8));
    }
}

package com.leetcode.array.problem;

import java.util.Arrays;

/**
 * 卡车上的最大单元数
 *
 * @author cangtan
 * @version V1.0
 * @see <a href="https://leetcode.cn/problems/maximum-units-on-a-truck/">卡车上的最大单元数</a>
 * @since 2022-11-15 11:21:00
 */
public class Solution1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 排序后扣减
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int result = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize >= boxType[0]) {
                truckSize -= boxType[0];
                result += boxType[1] * boxType[0];
            } else {
                result += boxType[1] * truckSize;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{2,1},{4,4},{3,1},{4,1},{2,4},{3,4},{1,3},{4,3},{5,3},{5,3}};

        int truckSize = 13;
        Solution1710 solution = new Solution1710();
        System.out.println(solution.maximumUnits(boxTypes, truckSize));
    }
}

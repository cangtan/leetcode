package com.leetcode.other.problem;

/**
 * 赢得比赛需要的最少训练时间
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-03-13 09:14:00
 */
public class Solution2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int length = energy.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            initialEnergy -= energy[i];
            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
            } else {
                result += experience[i] - initialExperience + 1;
                initialExperience = 2 * experience[i] + 1;
            }
        }
        if (initialEnergy <= 0) {
            result += Math.abs(initialEnergy) + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2383 solution = new Solution2383();
        int initialEnergy = 5;
        int initialExperience = 3;
        int[] energy = {1, 4};
        int[] experience = {2, 5};
        System.out.println(solution.minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }
}

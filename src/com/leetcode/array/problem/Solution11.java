package com.leetcode.array.problem;

import sun.font.GlyphLayout;

/**
 * @version V1.0
 * @Description: 盛最多水的容器
 * @author: ives
 * @date: 2020-12-21 17:19
 * @link: https://leetcode.com/problems/container-with-most-water
 */
public class Solution11 {
    /**
     * Two Pointers
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int area = currentHeight * (right - left);
            result = Math.max(area, result);
            while (left < right && height[left] <= currentHeight){
                left++;
            }
            while (left < right && height[right] <= currentHeight){
                right--;
            }
        }
        return result;
    }

//    public int maxArea(int[] height) {
//        int result = 0;
//        int left = 0;
//        int right = height.length - 1;
//        while (left < right) {
//            int currentHeight = Math.min(height[left], height[right]);
//            int area = currentHeight * (right - left);
//            result = Math.max(area, result);
//            if (height[left] > height[right]) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return result;
//    }
    public static void main(String[] args) {
        Solution11 solution = new Solution11();
        int[] height = {1,3,2,5,25,24,5};
        System.out.println(solution.maxArea(height));
    }
}

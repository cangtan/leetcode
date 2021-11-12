package com.leetcode.array.problem;

/**
 * 盛最多水的容器
 * @version V1.0
 * @author cangtan
 * @date 2020-12-21 17:19
 * @link https://leetcode.com/problems/container-with-most-water
 * 双指针遍历
 */
public class Solution11 {

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

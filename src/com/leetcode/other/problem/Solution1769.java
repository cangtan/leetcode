package com.leetcode.other.problem;

/**
 * 移动所有球到每个盒子所需的最小操作数
 *
 * @author cangtan
 * @version V1.0
 * @since 2022-12-02 09:24:00
 * @see <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/">移动所有球到每个盒子所需的最小操作数</a>
 */
public class Solution1769 {

    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        int left = boxes.charAt(0) - '0';
        int operations = 0;
        int right = 0;
        // operationi + lefti - righti
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                operations += i;
            }
        }
        result[0] = operations;
        for (int i = 1; i < boxes.length(); i++) {
            operations += left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            result[i] = operations;
        }
        return result;
    }

//    public int[] minOperations(String boxes) {
//        // 暴力破解
//        int[] result = new int[boxes.length()];
//        for (int i = 0; i < boxes.length(); i++) {
//            result[i] = 0;
//            for (int j = 0; j < boxes.length(); j++) {
//                if (i != j && boxes.charAt(j) == '1') {
//                    result[i] += Math.abs(j - i);
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution1769 solution = new Solution1769();
        String boxes = "110";
        int[] ints = solution.minOperations(boxes);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}

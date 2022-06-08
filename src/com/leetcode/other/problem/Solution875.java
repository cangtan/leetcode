package com.leetcode.other.problem;

/**
 * 爱吃香蕉的珂珂
 *
 * @author cangtan
 * @version V1.0
 * @date 2022-06-07 18:59:00
 * @see <a href="https://leetcode.cn/problems/koko-eating-bananas/">爱吃香蕉的珂珂</>
 */
public class Solution875 {

    public int minEatingSpeed(int[] piles, int h) {
        int right = Integer.MIN_VALUE;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        int left = 1;
        while (left < right) {
            int mid = left + right >> 1;
            int sum = 0;
            for (int pile : piles) {
                sum += pile / mid;
                if (pile % mid != 0){
                    sum++;
                }
            }
            if (sum <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    //    /**
//     * SUM(piles[i] / k) => h
//     * 暴力破解，每次自增k, 当合计值小等于h时结束
//     */
//    public int minEatingSpeed(int[] piles, int h) {
//        int k = 1;
//        while (true) {
//            long sum = 0;
//            for (int pile : piles) {
//                if (pile % k == 0) {
//                    sum += pile / k;
//                } else {
//                    sum += pile / k + 1;
//                }
//            }
//            if (sum <= (long) h) {
//                break;
//            }
//            k++;
//        }
//        return k;
//    }

    public static void main(String[] args) {
        Solution875 solution = new Solution875();
        int[] piles = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        int h = 823855818;
        System.out.println(solution.minEatingSpeed(piles, h));
    }
}

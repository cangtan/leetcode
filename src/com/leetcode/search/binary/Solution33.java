package com.leetcode.search.binary;

/**
 * 搜索旋转排序树组
 *
 * @author cangtan
 * @version V1.0
 * @since 2023-04-10 11:25:00
 */
public class Solution33 {
    /**
     * 整体数组都是以升序的方式
     * 只有有某个节点有一次降低
     * 将数组进行二分，判断左右哪一边为有序的数组，即 nums[left] < nums[right]
     * 并且判断target是否在有序的范围内，否则就继续二分另一侧数组
     * 如果 nums[0] <= nums[i]（为有序数组） 且 nums[0] <= target <= nums[i] 则在 0~i查找target
     * 如果 nums[0] > nums[i] 那么在0~i发生了下降，那么另一侧为有序数组，并且所有数字都是小于nums[0]大于nums[i]的
     * 将情况罗列如下
     * nums[0] <= target <= nums[i]
     * target <= nums[i] < nums[0]
     * nums[i] < nums[0] <= target
     * (三种情况均表示搜索 0 ~ i)
     * 所以我们进行三项判断：
     * <p>
     * (nums[0] <= target)， (target <= nums[i]) ，(nums[i] < nums[0])，
     * 现在我们想知道这三项中有哪两项为真（明显这三项不可能均为真或均为假（因为这三项可能已经包含了所有情况））
     * <p>
     * 所以我们现在只需要区别出这三项中有两项为真还是只有一项为真。
     * <p>
     * 使用 “异或” 操作可以轻松的得到上述结果（两项为真时异或结果为假，一项为真时异或结果为真，可以画真值表进行验证）
     * <p>
     * 之后我们通过二分查找不断做小 target 可能位于的区间直到 low==high，此时如果 nums[low]==target 则找到了，如果不等则说明该数组里没有此项。
     *
     * @author LukeLee
     * @see <a href = "https://leetcode.cn/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/">极简 Solution</a>
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == right && nums[left] == target) ? left : -1;
    }

    public static void main(String[] args) {
        Solution33 solution = new Solution33();
        int[] nums = {1, 3};
        int target = 1;
        System.out.println(solution.search(nums, target));
    }
}

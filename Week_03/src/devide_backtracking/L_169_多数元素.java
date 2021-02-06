package devide_backtracking;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 位运算 数组 分治算法
public class L_169_多数元素 {

    /**
     * 分治法，将数组一分为二比较左右出现的最多元素的次数
     */
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        //terminate
        if (left == right) return nums[left];

        //process
        int mid = (left + right) / 2;

        //drill down
        int leftNum = helper(nums, left, mid);
        int rightNum = helper(nums, mid + 1, right);
        if (leftNum == rightNum) return leftNum;
        int leftCount = getCount(nums, left, mid, leftNum);
        int rightCount = getCount(nums, mid + 1, right, rightNum);
        return leftCount > rightCount ? leftNum : rightNum;
    }

    private int getCount(int[] nums, int left, int right, int num) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }

}

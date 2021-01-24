package stack_queue;

import java.util.LinkedList;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
// 返回滑动窗口中的最大值。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// 示例 2：
//
//
//输入：nums = [1], k = 1
//输出：[1]
//
//
// 示例 3：
//
//
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
//
//
// 示例 4：
//
//
//输入：nums = [9,11], k = 2
//输出：[11]
//
//
// 示例 5：
//
//
//输入：nums = [4,-2], k = 2
//输出：[4]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
public class L_239_Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> window = new LinkedList<>();
        int maxNums[] = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //判断窗口中第一个元素是否小于当前下标，小于则出队
            if (!window.isEmpty() && window.peekFirst() < i - k + 1) {
                window.pollFirst();
            }
            //放进窗口的数要按照从大到小的顺序排列
            while (window.peekLast() != null && nums[i] > nums[window.peekLast()]) {
                window.pollLast();
            }
            //当前下表添加至队尾
            window.addLast(i);
            //如果窗口成型则记录最大值，最大值为对头元素
            if (i >= k - 1) {
                maxNums[i - k + 1] = nums[window.peekFirst()];
            }
        }
        return maxNums;
    }

}

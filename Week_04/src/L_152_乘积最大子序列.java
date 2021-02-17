//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划
public class L_152_乘积最大子序列 {

    /**
     * 两个指针min和max，当前遍历到的数字为负时交换
     */
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int result = nums[0];
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(num, max * num);
            min = Math.min(num, min * num);
            result = Math.max(result, max);
        }
        return result;
    }

}

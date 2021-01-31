package homework;

import java.util.*;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
public class L_46_全排列 {

    /**
     * 爆搜，递归+遍历寻找所有排列情况，利用List的contains函数判断数字是否重复
     * 时间复杂度：O(N×N!)
     * 空间复杂度：O(N×N!)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();
        helper(nums, deque, result);
        return result;
    }

    private void helper(int[] nums, LinkedList<Integer> deque, List<List<Integer>> result) {
        //terminator
        if (deque.size() == nums.length) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int num : nums) {
            //process
            if (!deque.contains(num)) {
                deque.offer(num);
                //drill down
                helper(nums, deque, result);
                //reverse states
                deque.removeLast();
            }
        }
    }

}

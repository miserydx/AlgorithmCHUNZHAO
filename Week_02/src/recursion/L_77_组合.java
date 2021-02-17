package recursion;

import java.util.ArrayList;
import java.util.List;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
public class L_77_组合 {

    /**
     * 思路类似全排列，在爆搜的基础上修改了了teminator条件即最大数量
     * 与全排列相比，遍历起点由遍历全部改为当前数字向后
     * 开始少加了个辅助变量depth记录当前递归栈的深度，导致一些情况的输出错误，这点要记下来
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) return result;
        List<Integer> array = new ArrayList<>();
        helper(n, k, 1, array, result);
        return result;
    }

    private void helper(int n, int k, int depth, List<Integer> array, List<List<Integer>> result) {
        //terminator
        if (array.size() >= k) {
            result.add(new ArrayList<>(array));
            return;
        }
        for (int i = depth; i <= n; i++) {
            //process
            array.add(i);
            //drill down
            helper(n, k, i + 1, array, result);
            //reverse states
            array.remove(array.size() - 1);
        }
    }

}

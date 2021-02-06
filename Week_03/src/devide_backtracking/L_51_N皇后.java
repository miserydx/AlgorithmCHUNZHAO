package devide_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[["Q"]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
//
//
//
// Related Topics 回溯算法
public class L_51_N皇后 {

    /**
     * 思路递归遍历每行
     * 如果当前位置满足条件则记录列、撇、捺后递归进入下一行
     * 如果当前位置不满足条件则进行回溯
     * 回溯后清除当前记录的列、撇、捺后向后遍历
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n < 1) return result;
        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> pies = new HashSet<>();
        HashSet<Integer> nas = new HashSet<>();
        List<Integer> records = new ArrayList<>();
        helper(n, 0, columns, pies, nas, records, result);
        return result;
    }

    private void helper(int n,
                        int row,
                        HashSet<Integer> columns,
                        HashSet<Integer> pies,
                        HashSet<Integer> nas,
                        List<Integer> records,
                        List<List<String>> result) {
        //terminate
        if (row >= n) {
            result.add(convert(records, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            //process
            //记录列存在则继续
            if (columns.contains(i)) continue;
            //记录撇存在则继续
            if (pies.contains(row + i)) continue;
            //记录捺存在则继续
            if (nas.contains(row - i)) continue;
            //都没重复则记录
            columns.add(i);
            pies.add(row + i);
            nas.add(row - i);
            records.add(i);
            //drill down
            helper(n, row + 1, columns, pies, nas, records, result);
            //reverse states
            columns.remove(i);
            pies.remove(row + i);
            nas.remove(row - i);
            records.remove(records.size() - 1);
        }

    }

    private List<String> convert(List<Integer> records, int n) {
        List<String> plan = new ArrayList<>();
        for (int i : records) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = '.';
            }
            row[i] = 'Q';
            plan.add(new String(row));
        }
        return plan;
    }

}

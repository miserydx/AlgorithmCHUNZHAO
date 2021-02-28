import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 回溯算法
public class L_22_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0, 0, n, "", result);
        return result;
    }

    private void helper(int left, int right, int n, String s, List<String> result) {
        //terminator
        if (left == n && right == n) {
            result.add(s);
        }
        //process and drill down
        if (left < n) {
            helper(left + 1, right, n, s + "(", result);
        }
        if (right < left) {
            helper(left, right + 1, n, s + ")", result);
        }
        //reverse state
    }

}

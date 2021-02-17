//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
//
//
// 示例 1：
//
//
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
//
//
// 示例 2：
//
//
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics 数组 动态规划
public class L_64_最小路径和 {

    /**
     * 思路类似不同路径
     * 当前点的最小值等于 min(left, top) + cur
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        //初始化第一行数据
        for (int i = 1; i < dp.length; i++) {
            dp[i] = grid[0][i - 1] + dp[i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {//如果是最左边，因为无left，所以这里直接+top
                    dp[j] += grid[i][j - 1];
                } else {//left和top选一个小的+
                    dp[j] = grid[i][j - 1] + Math.min(dp[j - 1], dp[j]);
                }
            }
        }
        return dp[n];
    }

}

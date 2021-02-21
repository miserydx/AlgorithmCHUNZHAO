//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//输出：4
//
//
// 示例 2：
//
//
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
//
//
// 示例 3：
//
//
//输入：matrix = [["0"]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 动态规划
public class L_221_最大正方形 {

    /**
     * dp[i][j]为当前最大正方形边长，等于左、左上、上中最小的+1
     * 进入判断的条件是左上=='1'
     * dp方程：dp[i+1][j+1] = min(dp[i][j], dp[i-1][j], dp[i][j-1]) + 1
     * 见附件图[file/最大正方形.png]
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (n < 1) return 0;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j], dp[i+1][j]), dp[i][j+1]) + 1;
                    max = Math.max(dp[i+1][j+1], max);
                }
            }
        }
        return max * max;
    }

}

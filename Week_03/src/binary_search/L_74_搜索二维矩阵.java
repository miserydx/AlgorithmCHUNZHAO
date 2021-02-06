package binary_search;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics 数组 二分查找
public class L_74_搜索二维矩阵 {

    /**
     * 二分查找矩阵的列和行
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) {
            return false;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            int[] rows = matrix[mid];
            if (target >= rows[0] && target <= rows[rows.length - 1]) {
                return searchInRow(rows, target);
            } else if (target < matrix[mid][matrix[mid].length - 1]) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return false;
    }

    private boolean searchInRow(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == target) {
                return true;
            } else if (target < row[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}

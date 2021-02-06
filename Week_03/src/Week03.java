import binary_search.L_74_搜索二维矩阵;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Week03 {

    public static void main(String[] args) {
//        new L_50_Pow().myPow(2,-3);
//        int[] nums = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
//        new L_860_柠檬水找零().lemonadeChange(nums);
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        new L_74_搜索二维矩阵().searchMatrix(matrix, 3);
    }

}

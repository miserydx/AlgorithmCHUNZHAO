package binary_tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
public class L_145_Binary_Tree_Postorder_Traversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        helper(node.left, result);
        helper(node.right, result);
        result.add(node.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }

}

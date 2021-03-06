package binary_tree;

import utils.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
public class l_589_N_ary_Tree_Preorder_Traversal {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; --i) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return result;
    }

}

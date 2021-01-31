package binary_tree;

import utils.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
public class l_590_N_ary_Tree_Postorder_Traversal {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.children != null) {
                for (int i = 0; i < node.children.size(); ++i) {
                    stack.push(node.children.get(i));
                }
            }
        }
        Collections.reverse(result);
        return result;
    }

}

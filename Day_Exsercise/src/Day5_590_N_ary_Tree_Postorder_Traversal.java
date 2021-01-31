import utils.Node;

import java.util.ArrayList;
import java.util.List;

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
public class Day5_590_N_ary_Tree_Postorder_Traversal {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.children == null || root.children.isEmpty()) {
            result.add(root.val);
            return;
        }
        for (Node node : root.children) {
            helper(node, result);
        }
        result.add(root.val);
    }

    public List<Integer> postorder2(Node root) {
        List<Integer> result = new ArrayList<>();

        return result;
    }

}

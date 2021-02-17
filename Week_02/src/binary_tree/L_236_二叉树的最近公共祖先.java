package binary_tree;

import utils.TreeNode;

public class L_236_二叉树的最近公共祖先 {

    /**
     * 递归寻找左右子节点是否有p,q
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        //terminator
        if (node == null || node == p || node == q) return node;
        //process

        //drill down
        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return node;
        //reverse states
    }

}

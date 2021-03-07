package binary_tree;

import utils.TreeNode;

public class L_98_验证二叉搜索树 {

    private long pre = Long.MIN_VALUE;

    /**
     * 中序遍历，即当前点要大于上一个节点才是二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

}

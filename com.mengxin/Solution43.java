/**
 * @author mx
 * @date 2020/8/23 - 0:04
 */
public class Solution43 {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode node) {
        if (node != null) {
            helper(node.left);
            helper(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
}

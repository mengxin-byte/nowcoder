import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mx
 * @date 2020/8/17 - 23:44
 */
public class Solution24 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        String path = "";
        helper(path, root);
        return res;
    }

    public void helper(String path, TreeNode node) {
        if (node != null) {
            path = path + node.val;
            if (node.left == null && node.right == null) {
                res.add(path);
            } else {
                path = path + "->";
                helper(path, node.left);
                helper(path, node.right);
            }
        }

    }
}

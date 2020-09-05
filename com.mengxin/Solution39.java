import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mx
 * @date 2020/8/22 - 22:21
 * 二叉树中序非递归遍历
 */

public class Solution39 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}

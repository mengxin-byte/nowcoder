import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mx
 * @date 2020/8/22 - 22:47
 * 二叉树非递归后序遍历
 */
public class Solution40 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        if (root == null) {
            return res;
        }
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node.val);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            res.add(stack2.pop());
        }
        return res;
    }
}

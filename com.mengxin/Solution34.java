import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mx
 * @date 2020/8/22 - 12:30
 * 二叉树非递归前序遍历
 */
public class Solution34 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null) {
            return arr;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            arr.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return arr;
    }
}

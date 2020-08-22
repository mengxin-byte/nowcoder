import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mx
 * @date 2020/8/18 - 0:03
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Solution26 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (root == null) {
            return res;
        }
        stack1.push(root);
        while (!stack1.isEmpty()) {
            List<Integer> arr1 = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                arr1.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            res.add(arr1);
            if (stack2.isEmpty()) {
                break;
            }
            List<Integer> arr2 = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode node = stack1.pop();
                arr2.add(node.val);
                if (node.right != null) {
                    stack2.push(node.right);
                }
                if (node.left != null) {
                    stack2.push(node.left);
                }
            }
            res.add(arr2);
        }
        return res;
    }
}

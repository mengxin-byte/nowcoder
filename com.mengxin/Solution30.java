import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mx
 * @date 2020/8/18 - 0:57
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 */
public class Solution30 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            } else {
                while (!queue.isEmpty()) {
                    if (queue.poll() != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

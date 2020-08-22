import java.awt.print.Pageable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mx
 * @date 2020/8/19 - 0:36
 */
public class Solution32 {
    int res = 0;
    public int widthOfBinaryTree(TreeNode root) {
        return res;
    }

    public void dfs(TreeNode node, int level, int index, List<Integer> arr) {
        if (node == null) {
            return;
        }
        if (level < arr.size()) {
            arr.add(index);
        }
        res = Math.max(res, index - arr.get(level - 1) + 1);
        dfs(node, level + 1, index * 2, arr);
        dfs(node, level + 1, index * 2 + 1, arr);
    }

//    public int widthOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int res = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int len = queue.size();
//            int left = len;
//            int right = -1;
//            for (int i = 0; i < len; i++) {
//                TreeNode node = queue.poll();
//                if (node != null) {
//                    left = Math.min(i, left);
//                    right = Math.max(right, i);
//                    queue.add(node.left);
//                    queue.add(node.right);
//                } else {
//                    queue.add(null);
//                    queue.add(null);
//                }
//            }
//            if (right == -1) {
//                break;
//            }
//            res = Math.max(res, right - left + 1);
//        }
//        return res;
//    }
}

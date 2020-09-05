import java.util.ArrayList;
import java.util.List;

/**
 * @author mx
 * @date 2020/8/23 - 11:07
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Solution48 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> arr = new ArrayList<>();
        search(root, sum, arr, 0);
        return res;
    }

    public void search(TreeNode root, int sum, ArrayList<Integer> arr, int cur) {
        if (root != null) {
            arr.add(root.val);
            cur += root.val;
            if (sum == cur && root.left == null && root.right == null) {
                ArrayList<Integer> tmp = new ArrayList<>(arr);
                res.add(tmp);
            }
            search(root.left, sum, arr, cur);
            search(root.right, sum, arr, cur);
            cur -= root.val;
            arr.remove(arr.size() - 1);
        }
    }
}

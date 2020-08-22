import java.util.ArrayList;

/**
 * @author mx
 * @date 2020/8/18 - 1:01
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Solution31 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    int sum = 0;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        search(root, target, arr);
        return res;
    }

    public void search(TreeNode node, int target, ArrayList<Integer> arr) {
        if (node != null) {
            sum += node.val;
            arr.add(node.val);
            if (node.left == null && node.right == null) {
                if (sum == target) {
                    ArrayList<Integer> tmp = new ArrayList<>(arr);
                    res.add(tmp);
                }
            } else {
                search(node.left, target, arr);
                search(node.right, target, arr);
            }
            sum -= node.val;
            arr.remove(arr.size() - 1);
        }
    }
}

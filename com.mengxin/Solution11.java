/**
 * @author mx
 * @date 2020/8/16 - 15:37
 * 树找两节点最长距离
 */
public class Solution11 {
    public static int findMaxLen(TreeNode node) {
        if (node != null) {
            int LD = getDepth(node.left);
            int RD = getDepth(node.right);
            return Math.max(LD + RD, Math.max(findMaxLen(node.left), findMaxLen(node.right)));
        } else {
            return 0;
        }
    }

    public static int getDepth(TreeNode node) {
        if (node != null) {
            int LD = getDepth(node.left);
            int RD = getDepth(node.right);
            return 1 + Math.max(LD, RD);
        } else {
            return 0;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

import java.util.Stack;

/**
 * @author mx
 * @date 2020/8/16 - 16:55
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class Solution15 {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (node != null && stack.size() < k) {
            stack.push(node);
            node = node.next;
        }
        if (stack.size() == k) {
            while (!stack.isEmpty()) {
                cur.next = stack.pop();
                cur = cur.next;
            }
        } else {
            if (stack.size() == 0) {
                return null;
            }
            while (stack.size() != 1) {
                stack.pop();
            }
            return stack.pop();
        }
        cur.next = reverseKGroup(node, k);
        return res.next;
    }
}

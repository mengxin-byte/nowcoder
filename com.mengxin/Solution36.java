import java.util.Stack;

/**
 * @author mx
 * @date 2020/8/22 - 12:42
 *
 *   给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *   k 是一个正整数，它的值小于或等于链表的长度。
 *   如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class Solution36 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(0);
        ListNode rear = res;
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(head);
            head = head.next;
            if (head == null) {
                break;
            }
        }
        ListNode next = stack.peek().next;
        if (stack.size() == k) {
            while (!stack.isEmpty()) {
                rear.next = stack.pop();
                rear = rear.next;
            }
        } else {
            while (stack.size() != 1) {
                stack.pop();
            }
            return stack.pop();
        }
        rear.next = reverseKGroup(next, k);
        return res.next;
    }
}

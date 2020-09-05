import java.util.List;

/**
 * @author mx
 * @date 2020/8/22 - 12:11
 * 反转一个单链表。
 */
public class Solution33 {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = res.next;
            res.next = head;
            head = tmp;
        }
        return res.next;
    }
}

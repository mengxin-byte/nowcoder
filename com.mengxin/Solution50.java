/**
 * @author mx
 * @date 2020/8/23 - 14:18
 * 请判断一个链表是否为回文链表。
 */
public class Solution50 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode pre = head;
        int len = 0;
        while (pre != null) {
            ++len;
            pre = pre.next;
        }
        pre = new ListNode(0);
        ListNode tmp = null;
        for (int i = 0; i < len / 2; i++) {
            tmp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = tmp;
        }
        if (len % 2 == 1) {
            head = head.next;
        }
        pre = pre.next;
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
        }
        return true;
    }
}

/**
 * @author mx
 * @date 2020/8/23 - 14:47
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 */

public class Solution52 {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode rear1 = l1;
        ListNode rear2 = l2;
        while (head != null) {
            if (head.val < x) {
                rear1.next = head;
                head = head.next;
                rear1 = rear1.next;
                rear1.next = null;
            } else {
                rear2.next = head;
                head = head.next;
                rear2 = rear2.next;
                rear2.next = null;
            }
        }
        if (l1.next == null) {
            return l2.next;
        } else {
            rear1.next = l2.next;
            return l1.next;
        }
    }
}

/**
 * @author mx
 * @date 2020/8/15 - 12:49
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution6 {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode rear = pre.next;
        while (rear != null) {
            int tmp = rear.val;
            if (rear != null && rear.next.val == tmp) {
                while (rear.val == tmp) {
                    rear = rear.next;
                    if (rear == null) {
                        break;
                    }
                }
                pre.next = rear;
            } else {
                pre = rear;
                if (pre != null) {
                    rear = rear.next;
                }

            }
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

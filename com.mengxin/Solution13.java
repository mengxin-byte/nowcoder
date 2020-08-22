/**
 * @author mx
 * @date 2020/8/16 - 15:53
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Solution13 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}

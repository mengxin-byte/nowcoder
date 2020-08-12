/**
 * @author mx
 * @date 2020/8/12 - 23:02
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random
 * 指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回
 * 参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution2 {
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode pre = pHead;
        while (pre != null) {
            RandomListNode node = new RandomListNode(pre.label);
            node.next = pre.next;
            pre.next = node;
            pre = pre.next.next;
        }
        pre = pHead;
        while (pre != null) {
            if (pre.random != null) {
                pre.next.random = pre.random.next;
            }
            pre = pre.next.next;
        }

        pre = pHead;
        RandomListNode rear = pre.next;
        RandomListNode res = rear;
        while (rear != null) {
            pre.next = rear.next;
            pre = pre.next;
            if (pre != null) {
                rear.next = pre.next;
            }
            rear = rear.next;
        }
        return res;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

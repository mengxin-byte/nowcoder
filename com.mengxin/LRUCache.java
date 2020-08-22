import java.util.HashMap;
import java.util.Map;

/**
 * @author mx
 * @date 2020/8/16 - 20:44
 */
public class LRUCache {

    class DLinkedNode {
        int val;
        int key;
        DLinkedNode pre;
        DLinkedNode next;
    }

    DLinkedNode head;
    DLinkedNode rear;
    int capacity;
    int size;
    Map<Integer, DLinkedNode> map = new HashMap<>();

    private void addNode(DLinkedNode node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode node = rear.pre;
        removeNode(node);
        return node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        rear = new DLinkedNode();
        head.next = rear;
        rear.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
        } else {
            node = new DLinkedNode();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addNode(node);
            ++size;
            if (size > capacity) {
                DLinkedNode tmp = popTail();
                int k = tmp.key;
                map.remove(k);
                --size;
            }
        }
    }
}

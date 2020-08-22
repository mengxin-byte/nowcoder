import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author mx
 * @date 2020/8/19 - 0:54
 */
public class LFUCache {

    Map<Integer, Node> map;
    Map<Integer, LinkedHashSet<Node>> freqMap;
    int capacity;
    int size;
    int min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        size = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            update(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            update(node);
        } else {
            if (size == capacity) {
                Node dead = removeNode();
                map.remove(dead.key);
                --size;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            ++size;
        }
    }

    private Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node dead = set.iterator().next();
        set.remove(dead);
        return dead;
    }

    private void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    private void update(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (min == freq && set.size() == 0) {
            min = freq + 1;
        }
        set = freqMap.get(freq + 1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(freq + 1, set);
        }
        node.freq++;
        set.add(node);
    }

    class Node {
        int key;
        int value;
        int freq = 1;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class LRUCache {
    int capacity;
    Node dummy;
    Map<Integer, Node> map;

    // @param capacity, an integer
    public Solution(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        dummy = new Node(0, 0);
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    // @return an integer
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeFromList(node);
            AddFirstToList(node);
            return node.value;
        }
        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        Node node = null;
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                // remove oldest
                map.remove(dummy.prev.key);
                removeFromList(dummy.prev);
            }
            node = new Node(key, value);
            map.put(key, node);
        } else {
            node = map.get(key);
            node.value = value;
            removeFromList(node);
        }
        AddFirstToList(node);
    }

    private void AddFirstToList(Node node) {
        node.next = dummy.next;
        node.next.prev = node;
        node.prev = dummy;
        dummy.next = node;
    }

    private void removeFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

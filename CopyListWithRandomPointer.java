/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // copy value
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode next = new RandomListNode(curr.label);
            next.next = curr.next;
            curr.next = next;
            curr = next.next;
        }

        // copy pointer
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // split
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        curr = head;
        while (curr != null) {
            tail.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            tail = tail.next;
        }
        return dummy.next;
    }

    /**
     * use hashmap.
     * Time: O(N)
     * Space: O(N)
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        while (head != null) {
            RandomListNode node = copy(head, map);
            if (head.random != null) {
                RandomListNode random = copy(head.random, map);
                node.random = random;
            }
            tail.next = node;
            tail = tail.next;
            head = head.next;
        }
        return dummy.next;
    }

    private RandomListNode copy(RandomListNode node, Map<RandomListNode, RandomListNode> map) {
        RandomListNode copy = null;
        if (map.containsKey(node)) {
            copy = map.get(node);
        } else {
            copy = new RandomListNode(node.label);
            map.put(node, copy);
        }
        return copy;
    }
}

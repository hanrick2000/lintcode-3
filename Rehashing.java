/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Rehashing {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }

        int capacity = hashTable.length * 2;
        ListNode[] result = new ListNode[capacity];
        for (ListNode head : hashTable) {
            while (head != null) {
                ListNode next = head.next;
                int hash = getHash(head, capacity);
                if (result[hash] != null) {
                    getTail(result[hash]).next = head;
                } else {
                    result[hash] = head;
                }
                head.next = null;
                head = next;
            }
        }
        return result;
    }

    private ListNode getTail(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
    private int getHash(ListNode node, int capacity) {
        return (node.val % capacity + capacity) % capacity;
    }

    public ListNode[] rehashing_notInsertToTheEndOfList(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }

        int capacity = hashTable.length * 2;
        ListNode[] result = new ListNode[capacity];
        for (ListNode head : hashTable) {
            while (head != null) {
                ListNode next = head.next;
                int hash = getHash(head, capacity);
                if (result[hash] != null) {
                    head.next = result[hash];
                } else {
                    head.next = null;
                }
                result[hash] = head;
                head = next;
            }
        }
        return result;
    }

    private int getHash(ListNode node, int capacity) {
        return (node.val % capacity + capacity) % capacity;
    }
}


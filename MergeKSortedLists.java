/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class MergeKSortedLists {
    /**
     * Time: O(NlogK)
     * Space: O(1)
     *
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.size(),
        new Comparator<ListNode>() {
            public int compare(ListNode h1, ListNode h2) {
                return h1.val - h2.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) {
                heap.offer(tail.next);
            }
        }
        return dummy.next;
    }
}


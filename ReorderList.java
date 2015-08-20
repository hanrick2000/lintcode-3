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
public class ReorderList {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = findMid(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        merge(head, tail);
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

    private void merge(ListNode head, ListNode tail) {
        ListNode curr = head;
        while (tail != null) {
            ListNode next = curr.next;
            curr.next = tail;
            tail = tail.next;
            curr.next.next = next;
            curr = next;
        }
    }
}


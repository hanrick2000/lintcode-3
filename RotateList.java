/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateList {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int len = getLength(head);
        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode prev = head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }
        while (tail.next != null) {
            tail = tail.next;
            prev = prev.next;
        }

        tail.next = head;
        ListNode result = prev.next;
        prev.next = null;
        return result;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}

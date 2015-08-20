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
public class ReverseLinkedListII {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        for (int i = 0; i < m - 1; i++) {
            curr = curr.next;
        }
        ListNode prev = curr;

        curr = curr.next;
        ListNode tail = curr;
        for (int i = m; i <= n; i++) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        tail.next = curr;

        return dummy.next;
    }
}

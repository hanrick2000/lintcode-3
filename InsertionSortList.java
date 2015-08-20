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
public class InsertionSortList {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode curr = dummy;
            while (curr.next != null && curr.next.val < head.val) {
                curr = curr.next;
            }
            ListNode next = head.next;
            head.next = curr.next;
            curr.next = head;
            head = next;
        }
        return dummy.next;
    }
}

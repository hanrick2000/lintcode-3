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
public class SortList {
    /**
     * merge sort
     * Time: O(NlogN)
     * Space: O(1)
     *
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode leftTail = findMid(head);
        ListNode right = sortList(leftTail.next);

        leftTail.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
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

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }
        if (h1 != null) {
            curr.next = h1;
        }
        if (h2 != null) {
            curr.next = h2;
        }
        return dummy.next;
    }

    // quick sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode smallTail = smallDummy;
        ListNode largeTail = largeDummy;
        ListNode pivot = head;
        ListNode pivotTail = pivot;
        head = head.next;
        while (head != null) {
            if (head.val < pivot.val) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else if (head.val > pivot.val) {
                largeTail.next = head;
                largeTail = largeTail.next;
            } else {
                pivotTail.next = head;
                pivotTail = pivotTail.next;
            }
            head = head.next;
        }
        smallTail.next = null;
        largeTail.next = null;

        smallDummy.next = sortList(smallDummy.next);
        // find small tail
        smallTail = smallDummy;
        while (smallTail.next != null) {
            smallTail = smallTail.next;
        }
        smallTail.next = pivot;
        pivotTail.next = sortList(largeDummy.next);

        return smallDummy.next;
    }
}


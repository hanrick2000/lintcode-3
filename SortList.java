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
        partition(head, smallDummy, largeDummy);

        smallDummy.next = sortList(smallDummy.next);
        largeDummy.next = sortList(largeDummy.next);

        ListNode smallTail = getTail(smallDummy);
        smallTail.next = head;
        head.next = largeDummy.next;
        return smallDummy.next;
    }


    private void partition(ListNode head, ListNode smallDummy, ListNode largeDummy) {
        int pivot = head.val;
        head = head.next;
        ListNode smallTail = smallDummy;
        ListNode largeTail = largeDummy;
        while (head != null) {
            if (head.val < pivot) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }
        smallTail.next = null;
        largeTail.next = null;
    }

    private ListNode getTail(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}


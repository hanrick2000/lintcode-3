/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SegmentTreeQuery {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null || start > end || end < root.start || end > root.end
            || start < root.start || start > root.end) {
            return -1;
        }
        // target == current range
        if (start == root.start && end == root.end) {
            return root.max;
        }
        int mid = root.start + (root.end - root.start) / 2;
        // target is in left half || in right half
        if (end <= mid) {
            return query(root.left, start, end);
        }
        if (start >= mid + 1) {
            return query(root.right, start, end);
        }
        // cross both halves
        return Math.max(query(root.left, start, mid), query(root.right, mid + 1, end));
    }
}

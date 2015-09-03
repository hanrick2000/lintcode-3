/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SegmentTreeQueryII {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null || start > end || end < root.start || start > root.end) {
            return 0;
        }
        if (end > root.end) {
            end = root.end;
        }
        if (start < root.start) {
            start = root.start;
        }
        if (root.start == start && root.end == end) {
            return root.count;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return query(root.left, start, end);
        }
        if (start >= mid + 1) {
            return query(root.right, start, end);
        }
        return query(root.left, start, mid) + query(root.right, mid + 1, end);
    }
}

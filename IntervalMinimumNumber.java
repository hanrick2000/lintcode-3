/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class IntervalMinimumNumber {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A,
                                                ArrayList<Interval> queries) {
        ArrayList<Integer> result = new ArrayList<>(queries.size());
        if (A == null || A.length == 0) {
            return result;
        }

        SegmentTreeNode root = build(A, 0, A.length - 1);
        setMin(A, root);

        for (Interval i : queries) {
            result.add(query(root, i.start, i.end));
        }
        return result;
    }

    private SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        return root;
    }

    private void setMin(int[] A, SegmentTreeNode root) {
        if (root.start == root.end) {
            root.min = A[root.start];
            return;
        }
        setMin(A, root.left);
        setMin(A, root.right);
        root.min = Math.min(root.left.min, root.right.min);
    }

    private int query(SegmentTreeNode root, int start, int end) {
        if (root == null || start > end || end < root.start || end > root.end
            || start < root.start || start > root.end) {
            return -1;
        }
        // target == current range
        if (start == root.start && end == root.end) {
            return root.min;
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
        return Math.min(query(root.left, start, mid), query(root.right, mid + 1, end));
    }
}

class SegmentTreeNode {
    int start;
    int end;
    int min;
    SegmentTreeNode left;
    SegmentTreeNode right;
    SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

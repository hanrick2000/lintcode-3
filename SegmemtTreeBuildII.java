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
public class SegmemtTreeBuildII {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        SegmentTreeNode root = build(A, 0, A.length - 1);
        setMax(A, root);
        return root;
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

    private void setMax(int[] A, SegmentTreeNode root) {
        if (root.start == root.end) {
            root.max = A[root.start];
            return;
        }
        setMax(A, root.left);
        setMax(A, root.right);
        root.max = Math.max(root.left.max, root.right.max);
    }
}

public class ConvertSortedArrayToBinarySearchTreeWithMinimalHeight {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null) {
            return null;
        }
        return build(A, 0, A.length - 1);
    }

    private TreeNode build(int[] A, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = build(A, low, mid - 1);
        root.right = build(A, mid + 1, high);
        return root;
    }
}


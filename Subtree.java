public class Subtree {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }
        if (equals(T1, T2)) {
            return true;
        }
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    private boolean equals(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        }
        if (T1 == null || T2 == null) {
            return false;
        }

        if (T1.val != T2.val) {
            return false;
        }

        return equals(T1.left, T2.left) && equals(T1.right, T2.right);
    }
}

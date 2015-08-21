public class MaximumDepthOfBinaryTree {
    /**
     * Time: O(h)
     * Space: O(1)
     *
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

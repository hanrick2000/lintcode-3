public class InsertNodeInBinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    // recursion
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }

    // iteration
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        TreeNode prev = root;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > node.val) {
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }

        if (prev.val > node.val) {
            prev.left = node;
        } else {
            prev.right = node;
        }
        return root;
    }
}

public class RemoveNodeInBinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        // divide
        if (value > root.val) {
            root.right = removeNode(root.right, value);
            return root;
        } else if (value < root.val) {
            root.left = removeNode(root.left, value);
            return root;
        } // else: root.val == value

        //
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        root.val = getValue(root);
        return root;
    }

    // replace root with smaller node's value, remove the node
    private int getValue(TreeNode root) {
        TreeNode prev = root;
        root = root.left;
        if (root.right == null) {
            prev.left = root.left;
            return root.val;
        }
        while (root.right != null) {
            prev = root;
            root = root.right;
        }
        prev.right = root.left;
        return root.val;
    }
}

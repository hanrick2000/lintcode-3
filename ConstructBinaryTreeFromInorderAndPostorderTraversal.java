public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0
            || inorder.length != postorder.length) {
            return null;
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);
        int index = getIndex(inorder, is, ie, postorder[pe]);
        root.left = build(inorder, is, index - 1, postorder, ps, ps + index - is - 1);
        root.right = build(inorder, index + 1, ie, postorder, ps + index - is, pe - 1);
        return root;
    }

    private int getIndex(int[] inorder, int is, int ie, int target) {
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        throw new IllegalArgumentException("Not fount " + target);
    }
}

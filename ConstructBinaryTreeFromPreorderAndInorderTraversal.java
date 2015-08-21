public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);

        int rootIndex = getIndex(inorder, is, ie, preorder[ps]);
        root.left = helper(preorder, ps + 1, ps + rootIndex - is, inorder, is, rootIndex - 1);
        root.right = helper(preorder, pe - ie + rootIndex + 1, pe, inorder, rootIndex + 1, ie);
        return root;
    }

    private int getIndex(int[] inorder, int s, int e, int target) {
        for (int i = s; i <= e; i++) {
            if (inorder[i] == target) return i;
        }
        return -1;
    }
}

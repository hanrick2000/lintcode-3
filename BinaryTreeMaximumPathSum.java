public class BinaryTreeMaximumPathSum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        return helper(root).max;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MIN_VALUE);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);
        int path = Math.max(root.val, root.val + Math.max(left.path, right.path));
        int max = Math.max(left.max, right.max);
        max = Math.max(max, Math.max(path, root.val + left.path + right.path));
        return new Result(path, max);
    }

    class Result {
        int path;
        int max;
        Result(int path, int max) {
            this.path = path;
            this.max = max;
        }
    }
}

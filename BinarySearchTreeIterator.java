/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */
public class BinarySearchTreeIterator {
    ArrayList<TreeNode> list = new ArrayList<>();
    int curr = 0;

    //@param root: The root of binary tree.
    public Solution(TreeNode root) {
        inorder(root, list);
    }

    private void inorder(TreeNode root, ArrayList<TreeNode> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root);
        inorder(root.right, result);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return curr < list.size();
    }

    //@return: return next node
    public TreeNode next() {
        return list.get(curr++);
    }
}

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
 */
public class MaxTree {
    /**
     * Time: O(NlogN)
     * Space: O(N)
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree_recursion(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        return maxTree(A, 0, A.length - 1);
    }

    private TreeNode maxTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = getMaxIndex(A, start, end);
        TreeNode root = new TreeNode(A[maxIndex]);
        root.left = maxTree(A, start, maxIndex - 1);
        root.right = maxTree(A, maxIndex + 1, end);
        return root;
    }

    private int getMaxIndex(int[] A, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (A[i] > A[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public TreeNode maxTree_stack(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(new TreeNode(A[0]));
        for (int i = 1; i < A.length; i++) {
            TreeNode rightNode = new TreeNode(A[i]);
            if (A[i] > stack.peek().val) {
                TreeNode node = stack.pop();
                while (!stack.isEmpty() && stack.peek().val < A[i]) {
                    TreeNode leftNode = stack.pop();
                    leftNode.right = node;
                    node = leftNode;
                }
                rightNode.left = node;
            }
            stack.push(rightNode);
        }

        TreeNode root = stack.pop();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            node.right = root;
            root = node;
        }
        return root;
    }

    public TreeNode maxTree_deque(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(new TreeNode(A[0]));
        for (int i = 1; i < A.length; i++) {
            TreeNode curr = new TreeNode(A[i]);
            while (!deque.isEmpty() && A[i] > deque.peekLast().val) {
                TreeNode prev = deque.pollLast();
                prev.right = curr.left;
                curr.left = prev;
            }
            deque.offerLast(curr);
        }

        TreeNode root = deque.pollFirst();
        TreeNode next = root;
        while (!deque.isEmpty()) {
            next.right = deque.pollFirst();
            next = next.right;
        }
        return root;
    }
}

class BinaryTreeSerialization {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        int height = getHeight(root);
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int l = 0; l < height; l++) {
            int size = (int)Math.pow(2, l);
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append("#,");
                    q.offer(null);
                    q.offer(null);
                } else {
                    sb.append(node.val + ",");
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
        }
        return sb.toString();
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }


        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (i < vals.length) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = q.poll();
                TreeNode left = null;
                TreeNode right = null;
                if (node == null) {
                    i += 2;
                } else {
                    if (!vals[i].equals("#")) { // left != null
                        left = new TreeNode(Integer.parseInt(vals[i]));
                        node.left = left;
                    }
                    i++;
                    if (!vals[i].equals("#")) { // right != null
                        right = new TreeNode(Integer.parseInt(vals[i]));
                        node.right = right;
                    }
                    i++;
                }
                q.offer(left);
                q.offer(right);
            }
        }
        return root;
    }
}


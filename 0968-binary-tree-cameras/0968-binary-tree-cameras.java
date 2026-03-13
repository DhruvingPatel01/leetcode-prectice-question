class Solution {
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        // If the root itself is still uncovered after the traversal, 
        // we must put a camera on it.
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }

    /**
     * Returns:
     * 0: Node is uncovered
     * 1: Node has a camera
     * 2: Node is covered (no camera)
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 2; // Null nodes are considered "covered"
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        // Case 1: If any child is uncovered, this node MUST have a camera
        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }

        // Case 2: If any child has a camera, this node is now covered
        if (left == 1 || right == 1) {
            return 2;
        }

        // Case 3: Both children are covered but have no cameras
        // This node is now uncovered and needs its parent to cover it
        return 0;
    }
}
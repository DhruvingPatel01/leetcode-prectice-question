class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        // If it's a leaf node, depth is 1
        if (root.left == null && root.right == null) return 1;
        
        // If left is null, we must go right
        if (root.left == null) return minDepth(root.right) + 1;
        
        // If right is null, we must go left
        if (root.right == null) return minDepth(root.left) + 1;
        
        // If both exist, take the minimum of the two
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
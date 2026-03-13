class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateGain(root);
        return maxSum;
    }

    private int calculateGain(TreeNode node) {
        if (node == null) return 0;

        // 1. Calculate the max gain from left and right subtrees.
        // We use Math.max(..., 0) to ignore branches with negative sums.
        int leftGain = Math.max(calculateGain(node.left), 0);
        int rightGain = Math.max(calculateGain(node.right), 0);

        // 2. The "Price" of the path passing THROUGH this node as a peak.
        // This is where we combine both subtrees with the node.
        int currentPathSum = node.val + leftGain + rightGain;

        // 3. Update the global maximum if this path is better.
        maxSum = Math.max(maxSum, currentPathSum);

        // 4. Return the max gain this node can offer to its parent.
        // IMPORTANT: A path can only go UP to a parent from ONE child.
        return node.val + Math.max(leftGain, rightGain);
    }
}
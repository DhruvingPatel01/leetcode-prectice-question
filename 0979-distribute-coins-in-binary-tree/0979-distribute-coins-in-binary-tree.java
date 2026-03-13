class Solution {
    private int totalMoves = 0;

    public int distributeCoins(TreeNode root) {
        calculateExcess(root);
        return totalMoves;
    }

    private int calculateExcess(TreeNode node) {
        if (node == null) return 0;

        // Recursively find the balance of the left and right subtrees
        int leftExcess = calculateExcess(node.left);
        int rightExcess = calculateExcess(node.right);

        // The number of moves needed to resolve the children's balance
        // is the absolute value of their excess (whether moving in or out)
        totalMoves += Math.abs(leftExcess) + Math.abs(rightExcess);

        // Return the current node's net balance to its parent:
        // (Current coins - 1 needed for self) + whatever children sent up
        return (node.val - 1) + leftExcess + rightExcess;
    }
}
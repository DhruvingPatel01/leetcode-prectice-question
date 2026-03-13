class Solution {
    public boolean isSymmetric(TreeNode root) {
        // A null tree is technically symmetric
        if (root == null) return true;
        
        // Check if the left and right subtrees are mirrors of each other
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // 1. Both are null: they match
        if (t1 == null && t2 == null) return true;
        
        // 2. One is null or values don't match: not symmetric
        if (t1 == null || t2 == null || t1.val != t2.val) return false;

        // 3. Compare outer children (t1.left & t2.right) 
        //    AND inner children (t1.right & t2.left)
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
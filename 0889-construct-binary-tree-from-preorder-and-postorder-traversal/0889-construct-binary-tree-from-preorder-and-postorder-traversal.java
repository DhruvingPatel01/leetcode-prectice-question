class Solution {
    int preIdx = 0;
    int postIdx = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Create the current root from the preorder index
        TreeNode root = new TreeNode(preorder[preIdx++]);

        // If the root's value is not the current postorder value, 
        // it means this root has children to process.
        if (root.val != postorder[postIdx]) {
            root.left = constructFromPrePost(preorder, postorder);
        }
        
        // After finishing the left side, if root is still not the 
        // current postorder value, it has a right child.
        if (root.val != postorder[postIdx]) {
            root.right = constructFromPrePost(preorder, postorder);
        }

        // Once we've processed all children, the current postorder
        // value must be this root. Increment postIdx and move up.
        postIdx++;
        return root;
    }
}
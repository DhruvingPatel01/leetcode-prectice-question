import java.util.HashMap;
import java.util.Map;

class Solution {
    int postIndex;
    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start from the last element of postorder
        postIndex = postorder.length - 1;
        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) return null;

        // Pick current node from postorder (from right to left)
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int splitIndex = inorderMap.get(rootVal);

        // Build RIGHT subtree before LEFT subtree
        root.right = helper(postorder, splitIndex + 1, right);
        root.left = helper(postorder, left, splitIndex - 1);

        return root;
    }
}
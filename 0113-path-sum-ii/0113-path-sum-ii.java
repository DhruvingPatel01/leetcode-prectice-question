import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }

    private void findPaths(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        // Add current node to the path
        currentPath.add(node.val);

        // Check if it's a leaf and the sum matches
        if (node.left == null && node.right == null && targetSum == node.val) {
            // We must create a new list because currentPath will continue to change
            result.add(new ArrayList<>(currentPath));
        } else {
            // Continue searching left and right
            findPaths(node.left, targetSum - node.val, currentPath, result);
            findPaths(node.right, targetSum - node.val, currentPath, result);
        }

        // BACKTRACK: Remove the current node before going back up the tree
        currentPath.remove(currentPath.size() - 1);
    }
}
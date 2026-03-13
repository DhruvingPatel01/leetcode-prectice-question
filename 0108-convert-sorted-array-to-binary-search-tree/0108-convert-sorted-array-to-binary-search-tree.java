class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        // Base case: if left pointer crosses right, we've exhausted this segment
        if (left > right) {
            return null;
        }

        // Choose the middle element to ensure height balance
        int mid = left + (right - left) / 2;
        
        TreeNode node = new TreeNode(nums[mid]);

        // Recursively build the subtrees
        node.left = constructBST(nums, left, mid - 1);
        node.right = constructBST(nums, mid + 1, right);

        return node;
    }
}
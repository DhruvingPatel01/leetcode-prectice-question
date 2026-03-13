import java.util.*;

class Solution {
    // Helper class to store node and its calculated index
    class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index; // First node's index at this level
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                // Normalize index to prevent potential overflow in deep trees
                int currIndex = current.index - minIndex; 
                TreeNode node = current.node;

                if (i == 0) first = currIndex;
                if (i == size - 1) last = currIndex;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * currIndex));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * currIndex + 1));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
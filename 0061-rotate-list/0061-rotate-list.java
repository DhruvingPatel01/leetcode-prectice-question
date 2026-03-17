/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Calculate the length of the list
        ListNode current = head;
        int length = 1; // Start at 1 to count the head
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Normalize k
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Step 3: Find the new tail and new head
        current.next = head; // Connect the end to the head to make it circular
        int newTailIndex = length - k; // Find the new tail index
        ListNode newTail = head;

        for (int i = 0; i < newTailIndex - 1; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next; // The new head is the next of new tail
        newTail.next = null; // Break the circle

        return newHead; // Return the new head of the rotated list
    }
}

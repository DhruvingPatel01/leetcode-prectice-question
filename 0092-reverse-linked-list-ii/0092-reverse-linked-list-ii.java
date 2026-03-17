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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to the node before the `left` position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Step 2: Start reversing from `left` to `right`
        ListNode curr = prev.next;
        ListNode tail = curr; // This will be the tail of the reversed sublist
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nextNode = curr.next; // Store the next node
            curr.next = prev.next;          // Reverse the link
            prev.next = curr;               // Move `curr` to the front
            curr = nextNode;                // Move to the next node
        }

        // Step 3: Connect the tail to the rest of the list
        tail.next = curr;

        return dummy.next; // Return the new head of the modified list
    }
}

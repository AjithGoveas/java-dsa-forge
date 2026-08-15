package LeetCode.LinkedLists;

/// # [L0234: Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list)
/// **Level:** Easy | **Pattern:** Reverse second half + compare (two pointers/fast-slow) | **TC / SC:** O(N) / O(1)
/// **Trigger:** "palindrome linked list"
/// **Traps:** Odd vs even length; single node; all values equal
/// Given the `head` of a singly linked list, return `true` if it is a _palindrome_ or `false` otherwise.
///
/// **Example 1:**
/// ```
/// Input: head = [1,2,2,1]
/// Output: true
/// ```
///
/// **Example 2:**
/// ```
/// Input: head = [1,2]
/// Output: false
/// ```
///
/// **Constraints:**
///
/// - The number of nodes in the list is in the range `[1,10^5]`.
/// - `0 <= Node.val <= 9`

public class L0234 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public boolean approachOne(ListNode head) {
            if (head == null || head.next == null) return true;

            // Find middle
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Reverse second half
            ListNode prev = null;
            while (slow != null) {
                ListNode nextTemp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = nextTemp;
            }

            // Compare halves
            ListNode left = head;
            ListNode right = prev;
            while (right != null) {
                if (left.val != right.val) return false;
                left = left.next;
                right = right.next;
            }

            return true;
        }

        // Function to reverse a linked list using the recursive approach
        public ListNode reverseLinkedList(ListNode head) {
            // Check if the list is empty or has only one node
            if (head == null || head.next == null) {
                return head;  // No change is needed; return the current head
            }

            // Recursive step: Reverse the remaining part of the list and get the new head
            ListNode newHead = reverseLinkedList(head.next);

            // Store the next node in 'front' to reverse the link
            ListNode front = head.next;

            // Update the 'next' pointer of 'front' to point to the current head
            front.next = head;

            // Set the 'next' pointer of the current head to null to break the original link
            head.next = null;

            // Return the new head obtained from the recursion
            return newHead;
        }

        // Function to check if the linked list is a palindrome
        public boolean isPalindrome(ListNode head) {
            // Check if the linked list is empty or has only one node
            if (head == null || head.next == null) {
                return true;  // It's a palindrome by definition
            }

            // Initialize two pointers, slow and fast, to find the middle of the linked list
            ListNode slow = head;
            ListNode fast = head;

            // Traverse the linked list to find the middle using slow and fast pointers
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;       // Move slow pointer one step at a time
                fast = fast.next.next;  // Move fast pointer two steps at a time
            }

            // Reverse the second half of the linked list starting from the middle
            ListNode newHead = reverseLinkedList(slow.next);

            // Pointer to the first half
            ListNode first = head;

            // Pointer to the reversed second half
            ListNode second = newHead;

            // Compare data values of nodes from both halves
            while (second != null) {
                if (first.val != second.val) {
                    // If values do not match, the list is not a palindrome
                    reverseLinkedList(newHead);  // Reverse the second half back to its original state
                    return false;
                }

                first = first.next;  // Move the first pointer
                second = second.next; // Move the second pointer
            }

            // Reverse the second half back to its original state
            reverseLinkedList(newHead);

            // The linked list is a palindrome
            return true;
        }
    }
}

package LeetCode.LinkedLists;

import java.util.Stack;

/// # [L0206: Reverse Linked List](https://leetcode.com/problems/reverse-linked-list)
/// ## Level - Easy
/// Given the head of a singly linked list, reverse the list, and return the reversed list.
///
/// **Example 1:**
/// ```
/// Input: head = [1,2,3,4,5]
/// Output: [5,4,3,2,1]
/// ```
///
/// **Example 2:**
/// ```
/// Input: head = [1,2]
/// Output: [2,1]
/// ```
///
/// **Example 3:**
/// ```
/// Input: head = []
/// Output: []
/// ```
///
/// **Constraints:**
///
/// - The number of nodes in the list is the range `[0,5000]`.
/// - `-5000 <= Node.val <= 5000`

public class L0206 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        // Function to reverse a linked list using stack
        public ListNode approachOne(ListNode head) {
            // Stack to store values of nodes
            Stack<Integer> stack = new Stack<>();

            // Temporary pointer to traverse the list
            ListNode temp = head;

            // Traverse and push all node values to stack
            while (temp != null) {
                stack.push(temp.val);
                temp = temp.next;
            }

            // Reset temp back to head
            temp = head;

            // Reassign values from stack in reverse order
            while (temp != null) {
                temp.val = stack.pop();
                temp = temp.next;
            }

            // Return the modified head
            return head;
        }

        // Function to reverse a linked list iteratively
        public ListNode approachTwo(ListNode head) {
            // Initialize previous pointer to null
            ListNode prev = null;

            // Start from the head of the list
            ListNode temp = head;

            // Traverse the list
            while (temp != null) {
                // Save the next node
                ListNode front = temp.next;

                // Reverse the current node's pointer
                temp.next = prev;

                // Move prev to current node
                prev = temp;

                // Move to the next node
                temp = front;
            }

            // Return new head (last node becomes first)
            return prev;
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: [1,2,3,4,5]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Example 1: ");
        printList(solution.reverseList(head1));

        // Example 2: [1,2]
        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.print("Example 2: ");
        printList(solution.reverseList(head2));

        // Example 3: []
        ListNode head3 = null;
        System.out.print("Example 3: ");
        printList(solution.reverseList(head3));
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        System.out.print("[");
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? ", " : ""));
            curr = curr.next;
        }
        System.out.println("]");
    }
}

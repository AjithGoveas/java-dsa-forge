package LeetCode.LinkedLists;

/// # [L0876: Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list)
/// **Level:** Easy | **Pattern:** Fast & Slow pointers (find middle) | **TC / SC:** O(N) / O(1)
/// **Trigger:** "middle of linked list"
/// **Traps:** Even length (return second middle); single node; two nodes
/// Given the `head` of a singly linked list, return the _middle node of the linked list_.
///
/// If there are two middle nodes, return **the second middle** node.
///
/// **Example 1:**
/// ```
/// Input: head = [1,2,3,4,5]
/// Output: [3,4,5]
/// Explanation: The middle node of the list is node 3.
/// ```
///
/// **Example 2:**
/// ```
/// Input: head = [1,2,3,4,5,6]
/// Output: [4,5,6]
/// Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
/// ```
///
/// **Constraints:**
///
/// - The number of nodes in the list is in the range `[1,100]`.
/// - `1 <= Node.val <= 100`

public class L0876 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    static class Solution {

        // Function to find the middle node of a linked list
        static ListNode approachOne(ListNode head) {
            // If the list is empty or has
            // only one element, return the head as
            // it's the middle.
            if (head == null || head.next == null) {
                return head;
            }

            ListNode temp = head;
            int count = 0;

            // Count the number of nodes
            // in the linked list.
            while (temp != null) {
                count++;
                temp = temp.next;
            }

            // Calculate the position of the middle node.
            int mid = count / 2 + 1;
            temp = head;

            while (temp != null) {
                mid = mid - 1;

                // Check if the middle
                // position is reached.
                if (mid == 0){
                    // break out of the loop
                    // to return temp
                    break;
                }
                // Move temp ahead
                temp = temp.next;
            }

            // Return the middle node.
            return temp;
        }

        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: [1,2,3,4,5]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode middle1 = solution.middleNode(head1);
        printList(middle1); // Expected: 3 4 5

        // Example 2: [1,2,3,4,5,6]
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        ListNode middle2 = solution.middleNode(head2);
        printList(middle2); // Expected: 4 5 6
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}

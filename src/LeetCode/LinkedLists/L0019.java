package LeetCode.LinkedLists;

/// # [L0019: Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)
/// **Level:** Medium | **Pattern:** Two Pointers (dummy node + fast/slow offset) | **TC / SC:** O(N) / O(1)
/// **Trigger:** "remove nth node from end of list"
/// **Traps:** n = length (removes head, use dummy); n = 1 (removes tail); single node
/// Given the `head` of a linked list, remove the `n`th node from the end of the list and return its head.
///
/// **Example 1:**
/// ```
/// Input: head = [1,2,3,4,5], n = 2
/// Output: [1,2,3,5]
/// ```
///
/// **Example 2:**
/// ```
/// Input: head = [1], n = 1
/// Output: []
/// ```
///
/// **Example 3:**
/// ```
/// Input: head = [1,2], n = 1
/// Output: [1]
/// ```
///
/// **Constraints:**
///
/// - The number of nodes in the list is `sz`.
/// - `1 <= sz <= 30`
/// - `0 <= Node.val <= 100`
/// - `1 <= n <= sz`

public class L0019 {
    static class ListNode {
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
        // Function to delete the Nth node from the end
        public ListNode approachOne(ListNode head, int N) {
            // If list is empty
            if (head == null) {
                return null;
            }

            int cnt = 0;
            ListNode temp = head;

            // Count total number of nodes
            while (temp != null) {
                cnt++;
                temp = temp.next;
            }

            // If N equals total nodes → delete head
            if (cnt == N) {
                return head.next;
            }

            // Calculate position from start
            int res = cnt - N;
            temp = head;

            // Traverse to the node before target
            while (temp != null) {
                res--;
                if (res == 0) {
                    break;
                }
                temp = temp.next;
            }

            // Delete the node
            temp.next = temp.next.next;

            return head;
        }

        // Function to delete the Nth node from the end 
        // using the optimized two-pointer method
        public ListNode deleteNthNodeFromEnd(ListNode head, int N) {
            // Create a dummy node before head to handle edge cases
            ListNode dummy = new ListNode(0, head);

            // Initialize slow and fast pointers at dummy
            ListNode slow = dummy;
            ListNode fast = dummy;

            // Move fast pointer N+1 steps ahead to create a gap
            for (int i = 0; i <= N; i++) {
                fast = fast.next;
            }

            // Move both pointers until fast reaches the end
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            // Slow is now at node before target → delete target node
            slow.next = slow.next.next;

            // Return updated head
            return dummy.next;
        }
    }
}

package LeetCode.LinkedLists;

import java.util.HashMap;

/// # [L0141: Linked List Cycle](https://leetcode.com/problems/linked-list-cycle)
/// ## Level - Easy
/// Given `head`, the head of a linked list, determine if the linked list has a cycle in it.
///
/// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter**.
///
/// Return `true` if there is a cycle in the linked list. Otherwise, return `false`.
///
/// **Example 1:**
/// ```
/// Input: head = [3,2,0,-4], pos = 1
/// Output: true
/// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
/// ```
///
/// **Example 2:**
/// ```
/// Input: head = [1,2], pos = 0
/// Output: true
/// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
/// ```
///
/// **Example 3:**
/// ```
/// Input: head = [1], pos = -1
/// Output: false
/// Explanation: There is no cycle in the linked list.
/// ```
///
/// **Constraints:**
///
/// - The number of the nodes in the list is in the range `[0,10^4]`.
/// - `-10^5 <= Node.val <= 10^5`
/// - `pos` is `-1` or a **valid index** in the linked-list.

public class L0141 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {
        // function to detect loop in linked list
        public boolean approachOne(ListNode head) {
            // Initialize a pointer 'temp'
            // at the head of the linked list
            ListNode temp = head;

            // Create a map to keep track of
            // encountered nodes
            HashMap<ListNode, Integer> nodeMap = new HashMap<>();

            // Step 2: Traverse the linked list
            while (temp != null) {
                // If the node is already in the
                // map, there is a loop
                if (nodeMap.containsKey(temp)) {
                    return true;
                }
                // Store the current node
                // in the map
                nodeMap.put(temp, 1);

                // Move to the next node
                temp = temp.next;
            }

            // Step 3: If the list is successfully traversed 
            // without a loop, return false
            return false;
        }
        
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }
}

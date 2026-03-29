package LeetCode.LinkedLists;

/// # [L0061: Rotate List](https://leetcode.com/problems/rotate-list)
/// ## Level - Medium
/// Given the `head` of a linked list, rotate the list to the right by `k` places.
///
/// **Example 1:**
///```
/// Input: head = [1,2,3,4,5], k = 2
/// Output: [4,5,1,2,3]
/// ```
///
/// **Example 2:**
///```
/// Input: head = [0,1,2], k = 4
/// Output: [2,0,1]
/// ```
///
/// **Constraints:**
/// - The number of nodes in the list is in the range `[0, 500]`.
/// - `-100 <= Node.val <= 100`
/// - `0 <= k <= 2 * 10^9`

public class L0061 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) return head;

            int length = 1;
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
                length++;
            }

            k = k % length;
            if (k == 0) return head;

            ListNode newTail = head;
            for (int i = 1; i < length - k; i++) {
                newTail = newTail.next;
            }
            ListNode newHead = newTail.next;

            newTail.next = null;
            tail.next = head;

            return newHead;
        }
    }

    // Utility: print linked list in array style
    private static void printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("head = [");

        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(", ");
            }
            head = head.next;
        }

        sb.append("]");
        System.out.println(sb);
    }


    // Utility: build sample linked list
    private static ListNode buildSampleList() {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(2, n3);

        return new ListNode(1, n4);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = buildSampleList();
        int k = 2;

        printLinkedList(head);
        System.out.println("k = " + k);

        ListNode res = s.rotateRight(head, k);

        printLinkedList(res);
    }
}

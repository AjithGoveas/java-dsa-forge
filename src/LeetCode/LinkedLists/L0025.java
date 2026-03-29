package LeetCode.LinkedLists;

/// # [L0025: Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group)
/// ## Level - Hard
/// Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return the modified list.
///
/// `k` is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of `k` then left-out nodes, in the end, should remain as it is.
///
/// You may not alter the values in the list's nodes, only nodes themselves may be changed.
///
/// **Example 1:**
/// ```
/// Input: head = [1,2,3,4,5], k = 2
/// Output: [2,1,4,3,5]
/// ```
///
/// **Example 2:**
/// ```
/// Input: head = [1,2,3,4,5], k = 3
/// Output: [3,2,1,4,5]
/// ```
///
/// **Constraints:**
/// - The number of nodes in the list is `n`.
/// - `1 <= k <= n <= 5000`
/// - `0 <= Node.val <= 1000`

public class L0025 {
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

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode groupPrev = dummy;

            while (true) {
                ListNode kth = getKth(groupPrev, k);
                if (kth == null) break;

                ListNode prev = kth.next;
                ListNode curr = groupPrev.next;
                ListNode temp;

                for (int i = 0; i < k; i++) {
                    temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }

                temp = groupPrev.next;
                groupPrev.next = kth;
                groupPrev = temp;
            }

            return dummy.next;
        }

        private ListNode getKth(ListNode head, int k) {
            while (head != null && k > 0) {
                head = head.next;
                k--;
            }

            return head;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = buildSampleList();
        int k = 2;

        printLinkedList(head);
        System.out.println("k = " + k);

        ListNode res = s.reverseKGroup(head, k);

        printLinkedList(res);
    }
}

package LeetCode.LinkedLists;

/// # [L0138: Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer)
/// ## Level - Medium
///
/// A linked list of length `n` is given such that each node contains an additional random pointer, which could point to any node in the list, or `null`.
///
/// Construct a _**deep copy**_ of the list. The deep copy should consist of exactly `n` **brand new** nodes, where each new node has its value set to the value of its corresponding original node.
/// Both the `next` and `random` pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
/// **None of the pointers in the new list should point to nodes in the original list**.
///
/// For example, if there are two nodes `X` and `Y` in the original list, where `X.random --> Y`, then for the corresponding two nodes `x` and `y` in the copied list, `x.random --> y`.
///
/// Return the head of the copied linked list.
///
/// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of `[val, random_index]` where:
///
/// `val`: an integer representing `Node.val`
///
/// `random_index`: the index of the node (range from `0` to `n-1`) that the `random` pointer points to, or `null` if it does not point to any node.
///
/// Your code will **only** be given the `head` of the original linked list.
///
/// **Example 1:**
/// ```txt
/// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
/// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
/// ```
/// **Example 2:**
/// ```txt
/// Input: head = [[1,1],[2,1]]
/// Output: [[1,1],[2,1]]
/// ```
/// **Example 3:**
/// ```txt
/// Input: head = [[3,null],[3,0],[3,null]]
/// Output: [[3,null],[3,0],[3,null]]
/// ```
///
/// **Constraints:**
/// - `0 <= n <= 1000`
/// - `-10^4 <= Node.val <= 10^4`
/// - `Node.random` is either `null` or points to some node in the linked list

public class L0138 {
    // Node definition
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        private void insertCopyInBetween(Node head) {
            Node temp = head;

            while(temp != null) {
                Node nextNode = temp.next;
                Node newNode = new Node(temp.val);
                newNode.next = nextNode;

                temp.next = newNode;
                temp = nextNode;
            }
        }

        private void connectRandomPointers(Node head) {
            Node temp = head;

            while(temp != null) {
                Node copyNode = temp.next;

                if(temp.random != null) {
                    copyNode.random = temp.random.next;
                } else {
                    copyNode.random = null;
                }

                temp = copyNode.next;
            }
        }

        private Node getDeepCopy(Node head) {
            Node temp = head;
            Node dummy = new Node(0);
            Node curr = dummy;

            while(temp != null) {
                curr.next = temp.next;
                curr = curr.next;

                temp.next = temp.next.next;
                temp = temp.next;
            }

            return dummy.next;
        }

        public Node copyRandomList(Node head) {
            if(head == null) return null;

            insertCopyInBetween(head);
            connectRandomPointers(head);
            return getDeepCopy(head);
        }
    }

    // Utility: print linked list
    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.val);
            System.out.print(", Random: " + (head.random != null ? head.random.val : "null"));
            System.out.println();
            head = head.next;
        }
    }

    // Utility: build sample linked list
    private static Node buildSampleList() {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        // Assign random pointers
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        Node head = buildSampleList();

        System.out.println("Original Linked List with Random Pointers:");
        printLinkedList(head);

        Node clonedList = s.copyRandomList(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
        printLinkedList(clonedList);
    }
}
package Recursion;

import java.util.Stack;

/// # Sort a Stack in Descending Order
/// **Level:** Medium | **Pattern:** Recursion (stack manipulation, insertion-style) | **TC / SC:** O(N^2) / O(N)
/// **Trigger:** "sort a stack", "sort using only stack operations", "no extra data structure"
/// **Traps:** Keeping order stable; using the call stack as the only auxiliary space; base cases for empty/single-element stacks
///
/// Sort a given stack so that its elements are in **descending order** (largest on top).
/// Only the stack and the recursive call stack are used — no arrays, lists, or loops that copy elements.
///
/// **Approach:**
///
/// 1. **Pop all elements** — `sortStack` pops the top element and recursively sorts the remaining stack.
/// 2. **Insert in position** — `insert` places the popped element back at its correct spot so the
///    stack stays sorted descending.
public class SortStackInDescending {
    static class Solution {
        // Insert `value` into a sorted stack while keeping it sorted (descending)
        private void insert(Stack<Integer> stk, int value) {
            // Base case: empty stack or the top is already <= value → push directly
            if (stk.isEmpty() || stk.peek() <= value) {
                stk.push(value);
                return;
            }

            // Pop the top until we find the perfect position for `value`
            int val = stk.pop();

            // Recursively insert `value` into the now-smaller stack
            insert(stk, value);

            // Put the popped element back on top (it's larger than `value`)
            stk.push(val);
        }

        // Sort the stack in descending order using only recursion
        public void sortStack(Stack<Integer> stack) {
            // Base case: empty stack → nothing to sort
            if (!stack.isEmpty()) {
                // Remove the top element
                int val = stack.pop();

                // Recursively sort the remaining stack
                sortStack(stack);

                // Insert the removed element at its correct sorted position
                insert(stack, val);
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        s.sortStack(stack);

        // Print the sorted stack
        System.out.print("Sorted stack (descending order): ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

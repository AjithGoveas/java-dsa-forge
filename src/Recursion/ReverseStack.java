package Recursion;

import java.util.Stack;

/// # Reverse a Stack
/// **Level:** Medium | **Pattern:** Recursion (stack manipulation, insert-at-bottom) | **TC / SC:** O(N^2) / O(N)
/// **Trigger:** "reverse a stack", "reverse using only stack operations", "no extra data structure"
/// **Traps:** Keeping order reversed; using the call stack as the only auxiliary space; base case for empty stack
///
/// Reverse a given stack so that its elements appear in the opposite order.
/// Only the stack and the recursive call stack are used — no arrays, lists, or loops that copy elements.
///
/// **Approach:**
///
/// 1. **Pop the top** — `reverseStack` pops the top element and recursively reverses the remaining stack.
/// 2. **Insert at the bottom** — after the sub-stack is reversed, the popped element is added at the
///    bottom (via `add`), so it ends up as the last/largest-index element.
///
/// **Execution trace (stack = [4, 1, 3, 2], top = 2):**
/// ```
/// reverseStack([4,1,3,2])      — pop 2
/// └─ reverseStack([4,1,3])     — pop 3
///    └─ reverseStack([4,1])    — pop 1
///       └─ reverseStack([4])   — pop 4
///          └─ reverseStack([]) → base case, return
///          add(4) → [4]
///       add(1) → [1, 4]
///    add(3) → [3, 1, 4]
/// add(2) → [2, 3, 1, 4]
/// ```
/// Popping the result gives: `4, 1, 3, 2` → reversed.
public class ReverseStack {
    static class Solution {
        // Reverse the stack using only recursion
        public void reverseStack(Stack<Integer> stack) {
            // Base case: empty stack → nothing to reverse
            if (stack.isEmpty()) return;

            // Remove the top element
            int top = stack.pop();

            // Recursively reverse the remaining stack
            reverseStack(stack);

            // Place the popped element at the BOTTOM of the reversed stack
            // (Stack.add appends at the end, i.e. the bottom)
            stack.add(top);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        s.reverseStack(stack);

        // Print the reversed stack
        System.out.print("Reverse stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

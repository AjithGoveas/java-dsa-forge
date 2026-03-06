package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/// # [L0451: Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency)
/// ## Level - Medium
/// Given a string `s`, sort it in **decreasing order** based on the **frequency** of the characters. The **frequency** of a character is the number of times it appears in the string.
///
/// Return _the sorted string_. If there are multiple answers, return _any of them_.
///
/// **Example 1:**
/// ```txt
/// Input: s = "tree"
/// Output: "eert"
/// Explanation: 'e' appears twice while 'r' and 't' both appear once.
/// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
/// ```
/// **Example 2:**
/// ```txt
/// Input: s = "cccaaa"
/// Output: "aaaccc"
/// Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
/// Note that "cacaca" is incorrect, as the same characters must be together.
/// ```
/// **Example 3:**
/// ```txt
/// Input: s = "Aabb"
/// Output: "bbAa"
/// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
/// Note that 'A' and 'a' are treated as two different characters.
/// ```

public class L0451 {
    static class Solution {
        public String frequencySort(String s) {
            // Count frequency
            HashMap<Character, Integer> freq = new HashMap<>();
            for (char ele : s.toCharArray()) {
                freq.put(ele, freq.getOrDefault(ele, 0) + 1);
            }

            // Create max heap => sort in decreasing order frequency
            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            pq.addAll(freq.entrySet());

            // Create a new mutable string
            StringBuilder sb = new StringBuilder();
            // Add the characters based on frequency
            while (!pq.isEmpty()) {
                Map.Entry<Character, Integer> entry = pq.poll();
                for (int i = 0; i < entry.getValue(); i++) sb.append(entry.getKey());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "Aabb";

        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.frequencySort(s));
    }
}

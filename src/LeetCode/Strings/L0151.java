package LeetCode.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/// # [L0151: Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string)
/// ## Level - Medium
/// Given an input string `s`, reverse the order of the **words**.
///
/// A **word** is defined as a sequence of non-space characters. The **words** in `s` will be separated by at least one space.
///
/// Return _a string of the words in reverse order concatenated by a single space_.
///
/// **Note** that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
///
/// **Example 1:**
/// ```txt
/// Input: s = "the sky is blue"
/// Output: "blue is sky the"
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: s = "  hello world  "
/// Output: "world hello"
/// Explanation: Your reversed string should not contain leading or trailing spaces.
/// ```
///
/// **Example 3:**
/// ```txt
/// Input: s = "a good   example"
/// Output: "example good a"
/// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
/// ```

public class L0151 {
    static class Solution {

        // Time complexity - O(n) or O(n^2)
        public String approachOne(String s) {

            String[] ss = s.split(" ");

            Arrays.sort(ss);

            return String.join(" ", ss);
        }

        // Brute force
        // Time Complexity - O(n)
        // Space Complexity - O(n)
        public String approachTwo(String s) {
            List<String> list = new ArrayList<>();

            StringBuilder str = new StringBuilder();
            for(char c : s.toCharArray()) {
                if (c != ' ') {
                    str.append(c);
                } else if (!str.isEmpty()) {
                    list.add(str.toString());
                    str.setLength(0);
                }
            }

            if (!str.isEmpty()) list.add(str.toString());

            Collections.reverse(list);
            return String.join(" ", list);
        }

        // optimal
        // Time Complexity - O(N)
        // Space Complexity - O(1)
        public String reverseWords(String s) {
            StringBuilder res = new StringBuilder();

            // Pointer to last index
            int i = s.length() - 1;

            while(i >= 0) {
                // remove trailing/leading spaces
                while (i > 0 && s.charAt(i) == ' ') {
                    i--;
                }

                // Stop loop once out of bound
                if (i < 0) break;

                int end = i;

                // move left till next index is a space
                while(i >= 0 && s.charAt(i) != ' ') {
                    i--;
                }

                // derive word using pointers
                String word = s.substring(i+1, end+1);

                // add space if the res has words
                if(!res.isEmpty()) res.append(" ");

                // create reversed word string
                res.append(word);
            }

            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "the sky is blue";

        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.reverseWords(s));
    }
}

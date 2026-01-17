package LeetCode.Strings;

import java.util.Arrays;

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
        public String reverseWords(String s) {
            StringBuilder res = new StringBuilder();

            String[] ss = s.split(" ");

            Arrays.sort(ss);

            for(int i = 0; i < ss.length; i++) {
                res.append(ss[i]);
                if(i != ss.length-1) res.append(" ");
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

package LeetCode.Arrays;

import java.util.Arrays;

/// # [Second Largest & Second Smallest]()
/// **Level:** Easy | **Pattern:** Single-pass min/max trackers | **TC / SC:** O(N) / O(1)
/// **Trigger:** "second largest", "second smallest"
/// **Traps:** Duplicate largest values; all identical elements (second largest undefined); array < 2 elements

public class SecondLargest {

    static class Solution {
        // Time complexity - O(n + n) => O(n)
        // Space complexity - O(1)
        public int[] getElements(int[] arr) {
            int size = arr.length;
            if (size == 0 || size == 1) {
                return new int[]{-1, -1};
            }

            int small = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;
            int large = Integer.MIN_VALUE, secondLarge = Integer.MIN_VALUE;

            for(int ele : arr) {
                if ( ele < small) {
                    secondSmall = small;
                    small = ele;
                } else if ( ele < secondSmall && ele != small) {
                    secondSmall = ele;
                }
            }

            for(int ele : arr) {
                if ( ele > large) {
                    secondLarge = large;
                    large = ele;
                } else if ( ele > secondLarge && ele != large) {
                    secondLarge = ele;
                }
            }

            return new int[]{secondSmall, secondLarge};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1, 2, 4, 7, 7, 5};
        System.out.println("Input: arr = " + Arrays.toString(arr));

        int[] res = solution.getElements(arr);
        System.out.println("Output: res = " + Arrays.toString(res));
    }
}

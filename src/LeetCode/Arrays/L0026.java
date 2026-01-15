package LeetCode.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/// # [L0026: Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
/// ## Level - Easy
/// Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates in-place such that each unique element appears only **once**. The **relative order** of the elements should be kept the **same**.
///
/// Consider the number of unique elements in `nums` to be `k`. After removing duplicates, return the number of unique elements `k`.
///
/// The first `k` elements of `nums` should contain the unique numbers in **sorted order**. The remaining elements beyond index `k - 1` can be ignored.
///
/// **Custom Judge:**
///
/// The judge will test your solution with the following code:
/// ```java
/// int[] nums = [...]; // Input array
/// int[] expectedNums = [...]; // The expected answer with correct length
///
/// int k = removeDuplicates(nums); // Calls your implementation
///
/// assert k == expectedNums.length;
/// for (int i = 0; i < k; i++){
///     assert nums[i] == expectedNums[i];
///}
///```
/// If all assertions pass, then your solution will be **accepted**.
///
/// Example 1:
/// ```txt
/// Input: nums = [1,1,2]
/// Output: 2, nums = [1,2,_]
/// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
/// It does not matter what you leave beyond the returned k (hence they are underscores).
///```
///
/// Example 2:
/// ```txt
/// Input: nums = [0,0,1,1,1,2,2,3,3,4]
/// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
/// Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
/// It does not matter what you leave beyond the returned k (hence they are underscores).
///```

public class L0026 {

    static class Solution {

        // approach is not suitable for cases where we have negative integers/elements
        public int frequencyApproach(int[] nums) {
            int max = Arrays.stream(nums).max().getAsInt();
            int[] freq = new int[max + 1];

            for (int i : nums) {
                freq[i]++;
            }
            int k = 0;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] != 0) {
                    nums[k++] = i;
                    freq[i]--;
                }
            }
            int ans = k;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] != 0) {
                    nums[k++] = i;
                    freq[i]--;
                }
            }

            return ans;
        }

        // Use a set to look for distinct elements and then place them in the first few places.
        public int approach1(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                set.add(i);
            }
            int index = 0;
            for (int i : set) {
                nums[index++] = i;
            }
            return index;
        }

        // Use two pointers and swap based on condition
        public int appraoch2(int[] nums) {
            int size = nums.length;
            int first = 0, second = 1;
            int count = 1;

            while (first < size && second < size) {
                if (nums[first] < nums[second]) {
                    first++;
                    swap(nums, first, second);
                    count++;
                }
                second++;
            }
            return count;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Optimal approach
        // This approach is optimized based on the approach 2
        // Time Complexity - O(n)
        // Space Complexity - O(1)
        public int removeDuplicates(int[] nums) {
            int size = nums.length;
            int first = 0, second = 1;

            while (second < size) {
                if (nums[first] != nums[second]) {
                    nums[first+1] = nums[second];
                    first++;
                }
                second++;
            }
            return first+1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Input: arr = " + Arrays.toString(arr));
        System.out.println("Output: " + solution.removeDuplicates(arr));
        System.out.println("Output: " + Arrays.toString(arr));
    }
}

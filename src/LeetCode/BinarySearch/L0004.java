package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0004: Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays)
/// ## Level - Hard
/// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
///
/// The overall run time complexity should be O(log (m+n)).
///
/// **Example 1:**
/// ```txt
/// Input: nums1 = [1,3], nums2 = [2]
/// Output: 2.00000
/// Explanation: merged array = [1,2,3] and median is 2.
/// ```
/// **Example 2:**
/// ```txt
/// Input: nums1 = [1,2], nums2 = [3,4]
/// Output: 2.50000
/// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
/// ```
///
/// **Constraints:**
///
/// - `nums1.length == m`
/// - `nums2.length == n`
/// - `0 <= m <= 1000`
/// - `0 <= n <= 1000`
/// - `1 <= m + n <= 2000`
/// - `-10^6 <= nums1[i], nums2[i] <= 10^6`

public class L0004 {
    static class Solution {
        // Brute force
        public double approachOne(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            int[] merged = new int[len1 + len2];
            System.arraycopy(nums1, 0, merged, 0, len1);
            System.arraycopy(nums2, 0, merged, len1, len2);
            Arrays.sort(merged);

            int totalLen = merged.length;
            if (totalLen % 2 == 0) {
                return (merged[totalLen / 2 - 1] + merged[totalLen / 2]) / 2.0;
            } else {
                return merged[totalLen / 2];
            }
        }

        // Two Pointer Approach
        public double approachTwo(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            int i = 0, j = 0;
            int median1 = 0, median2 = 0;

            for (int count = 0; count < (len1 + len2) / 2 + 1; count++) {
                median2 = median1;

                if (i < len1 && j < len2) {
                    if (nums1[i] > nums2[j]) {
                        median1 = nums2[j];
                        j++;
                    } else {
                        median1 = nums1[i];
                        i++;
                    }
                } else if (i < len1) {
                    median1 = nums1[i];
                    i++;
                } else {
                    median1 = nums2[j];
                    j++;
                }
            }

            if ((len1 + len2) % 2 == 0) {
                return (median1 + median2) / 2.0;
            } else {
                return (double) median1;
            }
        }

        // Recursive Binary Search Approach
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int left = (m + n + 1) / 2;
            int right = (m + n + 2) / 2;

            return (getKth(nums1, m, nums2, n, left, 0, 0) + getKth(nums1, m, nums2, n, right, 0, 0)) / 2.0;
        }

        private int getKth(int[] a, int m, int[] b, int n, int k, int aStart, int bStart) {
            if (m > n)
                return getKth(b, n, a, m, k, bStart, aStart);

            if (m == 0)
                return b[bStart + k - 1];

            if (k == 1)
                return Math.min(a[aStart], b[bStart]);

            int i = Math.min(m, k / 2);
            int j = Math.min(n, k / 2);

            if (a[aStart + i - 1] > b[bStart + j - 1]) {
                return getKth(a, m, b, n - j, k - j, aStart, bStart + j);
            } else {
                return getKth(a, m - i, b, n, k - i, aStart + i, bStart);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.findMedianSortedArrays(nums1, nums2));
    }
}

package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L1482: Minimum Number of Days to Make m Bouquets](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets)
/// ## Level - Medium
/// You are given an integer array `bloomDay`, an integer `m` and an integer `k`.
///
/// You want to make `m` bouquets. To make a bouquet, you need to use `k` **adjacent flowers** from the garden.
///
/// The garden consists of `n` flowers, the `ith` flower will bloom in the `bloomDay[i]` and then can be used in **exactly one** bouquet.
///
/// Return _the minimum number of days you need to wait to be able to make_ `m` _bouquets from the garden_. If it is impossible to make `m` bouquets return `-1`.
///
/// **Example 1:**
/// ```txt
/// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
/// Output: 3
/// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
/// We need 3 bouquets each should contain 1 flower.
/// After day 1: [x, _, _, _, _]   // we can only make one bouquet.
/// After day 2: [x, _, _, _, x]   // we can only make two bouquets.
/// After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
/// ```
/// **Example 2:**
/// ```txt
/// Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
/// Output: -1
/// Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
/// ```
/// **Example 3:**
/// ```txt
/// Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
/// Output: 12
/// Explanation: We need 2 bouquets each should have 3 flowers.
/// Here is the garden after the 7 and 12 days:
/// After day 7: [x, x, x, x, _, x, x]
/// We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
/// After day 12: [x, x, x, x, x, x, x]
/// It is obvious that we can make two bouquets in different ways.
/// ```
///
/// **Constraints:**
///
/// - `bloomDay.length == n`
/// - `1 <= n <= 10^5`
/// - `1 <= bloomDay[i] <= 10^9`
/// - `1 <= m <= 10^6`
/// - `1 <= k <= n`

public class L1482 {
    static class Solution {
        public int approachOne(int[] bloomDay, int m, int k) {
            int len = bloomDay.length;

            // flowersRequired > flowersAvailable => return -1;
            long flowersRequired = (long) m * k;
            if (flowersRequired > len) return -1;

            // Get min and max range
            int max = Arrays.stream(bloomDay).max().getAsInt();
            int min = Arrays.stream(bloomDay).min().getAsInt();

            for (int day = min; day <= max; day++) {
                if (isPossible(bloomDay, day, m, k)) return day;
            }

            return -1;
        }

        // Check whether, we can create 'm' bouquets, with 'k' adjacent flowers on day 'day'
        private boolean isPossible(int[] bloomDay, int day, int m, int k) {
            // no. of bouquets
            int bouquets = 0;
            // no. of blossomed flowers
            int count = 0;

            for (int bloom : bloomDay) {
                // if bloomDay <= day --> we can create a bouquet
                if (bloom <= day) {
                    count++;
                    // Check if the adjacent count is equal to the adjacent flowers required then we have a bouquet
                    if (count == k) {
                        bouquets++;
                        count = 0;
                    }
                } else count = 0;
            }

            // return true if bouquets is greater than or equal to the number required on that day
            return bouquets >= m;
        }

        public int minDays(int[] bloomDay, int m, int k) {
            int len = bloomDay.length;

            // flowersRequired > flowersAvailable => return -1;
            long flowersRequired = (long) m * k;
            if (flowersRequired > len) return -1;

            // Get min and max range
            int maxDay = Integer.MIN_VALUE;
            int minDay = Integer.MAX_VALUE;

            for (int bloom : bloomDay) {
                maxDay = Math.max(maxDay, bloom);
                minDay = Math.min(minDay, bloom);
            }

            // Binary search between minDay and maxDay
            int low = minDay, high = maxDay, res = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (isPossible(bloomDay, mid, m, k)) {
                    res = mid; // possible to form bouquets, try lower part
                    high = mid - 1;
                } else {
                    low = mid + 1;  // need more days
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        int m = 2;
        int k = 3;

        System.out.println("Input: bloomDay = " + Arrays.toString(bloomDay) + ", m = " + m + ", k = " + k);
        System.out.println("Output: " + sol.minDays(bloomDay, m, k));
    }
}

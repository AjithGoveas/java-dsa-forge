package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L1011: Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days)
/// ## Level - Medium
/// A conveyor belt has packages that must be shipped from one port to another within `days` days.
///
/// The `ith` package on the conveyor belt has a weight of `weights[i]`. Each day, we load the ship with packages on the conveyor belt (in the order given by `weights`). We may not load more weight than the maximum weight capacity of the ship.
///
/// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within `days` days.
///
/// **Example 1:**
/// ```txt
/// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
/// Output: 15
/// Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
/// 1st day: 1, 2, 3, 4, 5
/// 2nd day: 6, 7
/// 3rd day: 8
/// 4th day: 9
/// 5th day: 10
///
/// Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
/// ```
/// **Example 2:**
/// ```txt
/// Input: weights = [3,2,2,4,1,4], days = 3
/// Output: 6
/// Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
/// 1st day: 3, 2
/// 2nd day: 2, 4
/// 3rd day: 1, 4
/// ```
/// **Example 3:**
/// ```txt
/// Input: weights = [1,2,3,1,1], days = 4
/// Output: 3
/// Explanation:
/// 1st day: 1
/// 2nd day: 2
/// 3rd day: 3
/// 4th day: 1, 1
/// ```
///
/// **Constraints:**
///
/// - `1 <= days <= weights.length <= 5 * 104`
/// - `1 <= weights[i] <= 500`

public class L1011 {
    static class Solution {
        // Brute force
        public int approachOne(int[] weights, int days) {
            // left index => max weight as minimum capacity
            int left = Arrays.stream(weights).max().getAsInt();
            // right index => max load / total capacity
            int right = Arrays.stream(weights).sum();

            for(int capacity = left; capacity <= right; capacity++) {
                // calculate days needed
                int daysNeeded = calculateDays(weights, capacity);
                // if less days required => return capacity
                if(daysNeeded <= days) return capacity;
            }

            // if none => max load
            return right;
        }
        private int calculateDays(int[] weights, int capacity) {
            // count days from 1
            int days = 1;
            // current load => 0
            int currentLoad = 0;

            for(int weight : weights) {
                // if current capacity is greater that given capacity => take remaining load to next day
                if((currentLoad + weight) > capacity) {
                    days++;
                    currentLoad = weight;
                } else {
                    currentLoad += weight;
                }
            }

            return days;
        }

        // Optimal
        public int approachTwo(int[] weights, int days) {
            // left index => max weight as minimum capacity
            int left = Arrays.stream(weights).max().getAsInt();
            // right index => max load / total capacity
            int right = Arrays.stream(weights).sum();

            while(left <= right) {
                int mid = left + (right - left) / 2;
                // calculate days needed
                int daysNeeded = calculateDays(weights, mid);
                // if less days required => return capacity
                if(daysNeeded <= days) right = mid - 1;
                else left = mid + 1;
            }

            // if none => minimum capacity
            return left;
        }

        // Optimal
        public int shipWithinDays(int[] weights, int days) {
            // left index => max weight as minimum capacity
            int left = 0;
            // right index => max load / total capacity
            int right = 0;

            for(int weight : weights) {
                left = Math.max(left, weight);
                right += weight;
            }

            while(left <= right) {
                int mid = left + (right - left) / 2;
                // calculate days needed
                int daysNeeded = calculateDays(weights, mid);
                // if less days required => return capacity
                if(daysNeeded <= days) right = mid - 1;
                else left = mid + 1;
            }

            // if none => minimum capacity
            return left;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println("Input: weights = " + Arrays.toString(weights) + ", days = " + days);
        System.out.println("Output: " + sol.shipWithinDays(weights, days));
    }
}

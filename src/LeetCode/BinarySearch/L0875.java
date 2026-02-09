package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0875: Koko Eating Bananas]()
/// ## Level - Medium
/// Koko loves to eat bananas. There are `n` piles of bananas, the ith pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours.
///
/// Koko can decide her bananas-per-hour eating speed of `k`. Each hour, she chooses some pile of bananas and eats `k` bananas from that pile. If the pile has less than `k` bananas, she eats all of them instead and will not eat any more bananas during this hour.
///
/// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
///
/// Return the minimum integer `k` such that she can eat all the bananas within `h` hours.
///
/// **Example 1:**
/// ```txt
/// Input: piles = [3,6,7,11], h = 8
/// Output: 4
/// ```
/// **Example 2:**
/// ```txt
/// Input: piles = [30,11,23,4,20], h = 5
/// Output: 30
/// ```
/// **Example 3:**
/// ```txt
/// Input: piles = [30,11,23,4,20], h = 6
/// Output: 23
/// ```
///
/// **Constraints:**
///
/// - `1 <= piles.length <= 10^4`
/// - `piles.length <= h <= 10^9`
/// - `1 <= piles[i] <= 10^9`

public class L0875 {
    static class Solution {
        public int approachOne(int[] piles, int h) {
            int largePile = Arrays.stream(piles).max().getAsInt();

            for (int speed = 1; speed <= largePile; speed++) {
                int totalHrsRequired = calculateHours(piles, speed);

                if (totalHrsRequired <= h) return speed;
            }

            return largePile;
        }

        private int calculateHours(int[] piles, int speed) {
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + speed - 1) / speed; // safe integer ceiling division
            }
            return hours;
        }


        public int minEatingSpeed(int[] piles, int h) {
            int maxPile = Arrays.stream(piles).max().getAsInt();

            int low = 1, high = maxPile;
            int ans = maxPile;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                int calculateHours = calculateHours(piles, mid);

                if (calculateHours <= h) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;

        System.out.println("Input: piles = " + Arrays.toString(piles) + ", h = " + h);
        System.out.println("Output: " + solution.minEatingSpeed(piles, h));
    }
}

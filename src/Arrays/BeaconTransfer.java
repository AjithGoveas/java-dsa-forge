package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class BeaconTransfer {
    static class Solution {
        public int getAns(int N, int A, int[] stock) {
            // Base case, if N == 1
            int maxBurn = 1;

            // Iterate over all stocks
            for (int i = 0; i < N - 1; i++) {
                // Copy the stock to temp
                int[] temp = stock.clone();

                // Perform transfer at index 1
                int transferValue = temp[i];
                temp[i] = 0;
                if (i - 1 >= 0) temp[i - 1] = 0;
                temp[i + 1] += transferValue;

                // Calculate localMax
                int localMax = 0;
                for (int j = 0; j < N; j++) {
                    localMax = Math.max(localMax, Math.max(1, temp[j]));
                }

                maxBurn = Math.max(maxBurn, localMax);
            }
            return A * maxBurn;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // Test cases
        int[] N = {3, 4, 4};
        int[] A = {10, 5, 7};
        int[][] S = {{1, 0, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}};

        for (int i = 0; i < N.length; i++) {
            System.out.println("N = " + N[i]);
            System.out.println("A = " + A[i]);
            System.out.println("stock = " + Arrays.toString(S[i]));
            int result = s.getAns(N[i], A[i], S[i]);
            System.out.println(result);
            System.out.println();
        }
    }
}

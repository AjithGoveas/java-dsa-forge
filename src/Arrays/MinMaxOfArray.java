package Arrays;

import java.util.Arrays;

public class MinMaxOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 45, 76, 24, 67, 90, 55, 62};
        System.out.println("Array: " + Arrays.toString(arr));

        // Minimum element of the array
        int minValue = min(arr);

        // Maximum element of the array
        int maxValue = max(arr);

        System.out.println("Min: " + minValue);
        System.out.println("Max: " + maxValue);

        System.out.println("Min in range 2 to 8: " + minInRange(arr, 2, 8));
        System.out.println("Max in range 2 to 8: " + maxInRange(arr, 2, 8));
    }

    static int min(int[] arr) {
        int minValue = arr[0];

        for (int ele : arr) {
            // min = ele < min ? ele : min;
            minValue = Math.min(minValue, ele);
        }

        return minValue;
    }

    static int minInRange(int[] arr, int start, int end) {
        int minValue = arr[start];

        for (int i = start; i <= end; i++) {
            int ele = arr[i];
            // min = ele < min ? ele : min;
            minValue = Math.min(minValue, ele);
        }

        return minValue;
    }

    static int max(int[] arr) {
        int maxValue = arr[0];

        for (int ele : arr) {
            // max = ele > max ? ele : max;
            maxValue = Math.max(maxValue, ele);
        }

        return maxValue;
    }

    static int maxInRange(int[] arr, int start, int end) {
        int maxValue = arr[start];

        for (int i = start; i <= end; i++) {
            int ele = arr[i];
            // max = ele > max ? ele : max;
            maxValue = Math.max(maxValue, ele);
        }

        return maxValue;
    }
}

package Arrays.SearchAlgorithms;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-55, -24, 12, 18, 24, 36, 45, 59, 65, 71, 83, 99};

        System.out.println("Array: " + Arrays.toString(arr));

        int target = -24;
        System.out.println("Target: " + target);

        int result = binarySearch(arr, target);
        System.out.println("Result: " + result);
    }

    // Ascending Order
    static int binarySearch(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) return mid;
            else if (target > arr[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    // Descending Order
    static int binarySearch2(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) return mid;
            else if (target > arr[mid]) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    static int orderAgnosticBinarySearch(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int low = 0;
        int high = arr.length - 1;

        boolean isAsc = arr[low] < arr[high];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) return mid;
            if (isAsc) {
                if (target > arr[mid]) low = mid + 1;
                else high = mid - 1;
            }
            else {
                if (target > arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
        }

        return -1;
    }
}

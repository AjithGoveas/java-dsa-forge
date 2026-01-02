package Arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 45, 76, 24, 67, 90, 55, 62};

        System.out.println("Before reversing: " + Arrays.toString(arr));

        reverseArray(arr);
        System.out.println("After reversing: " + Arrays.toString(arr));
    }

    // Two Pointer Approach
    static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

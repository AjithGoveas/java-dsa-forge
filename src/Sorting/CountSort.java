package Sorting;

import java.util.Arrays;

public class CountSort {

    // Optimized countSort
    static void optimizedCountSort(int[] arr) {
        // find the largest element
        int largest = largest(arr);

        // frequency array
        int[] freq = new int[largest + 1];
        for (int ele : arr) {
            freq[ele]++;
        }

        // Calculate the prefix sum
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        // create output array
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = freq[val] - 1;
            output[pos] = val;
            freq[val]--;
        }

        // copy back to original
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = output[i];
        }
    }

    // Works fine
    static void countSort(int[] arr) {
        // find the largest number in the array
        int largest = largest(arr);

        // Initialize a frequency array with size = largest + 1
        int[] freq = new int[largest + 1];
        for (int i : arr) {
            freq[i]++;
        }

        int k = 0;
        for (int j = 0; j < freq.length; j++) {
            while (freq[j]-- > 0) {
                arr[k++] = j;
            }
        }
    }

    static int largest(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 3, 2, 5, 2, 8};

        System.out.println("Before Sorting: " + Arrays.toString(arr));
        optimizedCountSort(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
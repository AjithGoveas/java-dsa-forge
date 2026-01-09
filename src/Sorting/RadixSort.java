package Sorting;

import java.util.Arrays;

public class RadixSort {

    static void radixSort(int[] arr) {
        // get max element of the array
        int max = Arrays.stream(arr).max().getAsInt();

        // do countSort for every digit place
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    static void countSort(int[] arr, int exp) {
        int size = arr.length;
        int[] output = new int[size];
        // we know that our frequency array is nothing but the count
        // and this count is for digits 0 to 9 => decimal number system
        int[] count = new int[10];

        // frequency count of digits
        for (int j : arr) {
            int num = j / exp;     // 471 -> 471 / 1 (for exp = 1)
            int digit = num % 10;       // 471 -> 471 % 10 (for the above num = 471 / 1)
            count[digit]++;             // 471 -> digit = 1
        }

        // calculate the prefix sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // fill the output array
        for (int i = size - 1; i >= 0; i--) {
            int num = arr[i] / exp;
            int digit = num % 10;
            int pos = count[digit] - 1;
            output[pos] = arr[i];
            count[digit]--;
        }

        // copy back to original array
        System.arraycopy(output, 0, arr, 0, size);
    }

    public static void main(String[] args) {
        int[] arr = {29, 83, 471, 36, 91, 8};

        System.out.println("Before sorting: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}

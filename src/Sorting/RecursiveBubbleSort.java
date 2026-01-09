package Sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {

    static void recursiveBubbleSort(int[] arr, int low, int high) {
        if (low == high) return;

        // Single pass => push the largest element to the last
        for (int j = low; j < high; j++) {
            if(arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
            }
        }

        // call recursively with decrement high
        recursiveBubbleSort(arr, low, high - 1);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        System.out.println("Input: arr = " + Arrays.toString(arr));

        recursiveBubbleSort(arr, 0, arr.length - 1);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}

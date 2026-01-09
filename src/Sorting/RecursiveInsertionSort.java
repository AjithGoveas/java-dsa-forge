package Sorting;

import java.util.Arrays;

public class RecursiveInsertionSort {

    static void recursiveInsertionSort(int[] arr, int low, int high) {
        // Base Case
        if ( low == high) return;

        int j = high;
        // Single pass of insertion sort
        while(j > low && arr[j-1] > arr[j]) {
            swap(arr, j-1, j);
            j--;
        }

        // Recursive call for next index;
        recursiveInsertionSort(arr, low+1, high);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        System.out.println("Input: arr = " + Arrays.toString(arr));

        recursiveInsertionSort(arr, 0, arr.length - 1);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}

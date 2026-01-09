package Sorting;

import java.util.Arrays;

public class QuickSort {

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // find the pivot index
            int pIndex = partition(arr, low, high);

            // Recursively sort the left and right sides with same algorithm
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        // taking 1st element as pivot
        int pivot = arr[low];

        int i = low;
        int j = high;

        while (i < j) {
            // greater element from the left part
            while(arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            // smaller element from the right part
            while(arr[j] > pivot && j >= low + 1) {
                j--;
            }

            // swap the smaller element with the greater element taking pivot as reference
            if (i < j) swap(arr, i, j);
        }

        // swap when i > j and j is the partition index
        swap(arr, low, j);
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};

        System.out.println("Before sorting: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length-1);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}

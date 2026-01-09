package Sorting;

import java.util.Arrays;

public class CyclicSort {

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            // Check: value must be in range AND not already in correct place
            if (arr[i] >= 1 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
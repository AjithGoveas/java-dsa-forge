package Sorting;

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;

            while(j > 0 && arr[j-1] > arr[j]) {
                swap(arr, j-1, j);
                j--;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        System.out.println("Input: arr = " + Arrays.toString(arr));

        insertionSort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}

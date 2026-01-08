package Sorting;

import java.util.Arrays;

public class BubbleSort {

    static void optimizedBubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void bubbleSort(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 1; j < arr.length - i; j++) {
//                if (arr[j - 1] > arr[j]) swap(arr, j-1, j);
//            }
//        }
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        System.out.println("Input: arr = " + Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("Output: " + Arrays.toString(arr));

        System.out.println("\nOptimized:");
        int[] arr1 = {13, 46, 24, 52, 20, 9};
        System.out.println("Input: arr = " + Arrays.toString(arr1));

        optimizedBubbleSort(arr1);
        System.out.println("Output: " + Arrays.toString(arr1));
    }
}

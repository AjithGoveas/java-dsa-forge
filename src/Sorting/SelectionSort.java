package Sorting;

import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) minIndex = j;
            }
            swap(arr, i, minIndex);
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

        selectionSort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}

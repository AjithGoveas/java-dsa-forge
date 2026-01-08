package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high) {
        // Create a temporary dynamic array
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        // Merge until one side of the array is filled or both sides
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // If elements from left are remaining
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // If elements from right are remaining
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Now replace original array with the new merged temp array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};

        System.out.println("Before sorting: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}

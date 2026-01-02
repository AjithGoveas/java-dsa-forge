package Arrays.SearchAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class LinerSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Initialize array
        ArrayList<Integer> arr = new ArrayList<>(5);

        System.out.print("Enter array size: ");
        int size = in.nextInt();

        System.out.print("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            arr.add(in.nextInt());
        }

        System.out.print("Enter element to search: ");
        int target = in.nextInt();

        int result = linearSearch(arr, target);

        System.out.println("Search result: " + result);

        System.out.print("Enter start and end range: ");
        int start = in.nextInt();
        int end = in.nextInt();

        System.out.print("Enter target: ");
        target = in.nextInt();

        result = linearSearchInRange(arr, target, start, end);
        System.out.println("Search in range " + start + "-" + end + ": "  + result);
        in.close();
    }

    static int linearSearch(ArrayList<Integer> arr, int target) {
        // Basic isEmpty check
        if (arr.isEmpty()) {
            return -1;
        }

        // Search using Loop
        for (int index = 0; index < arr.size(); index++) {
            if (arr.get(index) == target) {
                return index;
            }
        }

        // If element not found after all traversal
        return -1;
    }

    static int linearSearchInRange(ArrayList<Integer> arr, int target, int start, int end) {
        if (arr.isEmpty()) {
            return -1;
        }

        for (int index = start; index <= end; index++) {
            if(arr.get(index) == target) return index;
        }

        return -1;
    }

    static int linearSearch(String str, int target) {
        // Basic isEmpty check
        if (str.isEmpty()) {
            return -1;
        }

        // Search using Loop
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index) == target) {
                return index;
            }
        }

        // If element not found after all traversal
        return -1;
    }
}

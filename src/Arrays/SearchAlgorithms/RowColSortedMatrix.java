package Arrays.SearchAlgorithms;

import java.util.Arrays;

public class RowColSortedMatrix {
    static int[] search(int[][] arr, int target) {
        int row = 0;
        int col = arr.length - 1;   // depends on the given matrix =>

        while(row < arr.length && col >= 0) {
            if(arr[row][col] == target) return new int[]{row, col};

            if (arr[row][col] < target) row++;
            else col--;
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
//        int[][] arr = {
//                {10, 20, 30, 40},
//                {15, 25, 35, 45},
//                {28, 29, 37, 49},
//                {33, 34, 38, 50}
//        };
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int target = 7;

        int[] res = search(arr, target);
        System.out.println("Position is " + Arrays.toString(res));
    }
}

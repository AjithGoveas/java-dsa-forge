package Arrays.SearchAlgorithms;

import java.util.Arrays;

public class Search2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 20, 35, 4 },
                { 5, 65, 7, 82 },
                { 95, 10, 111, 12, 16 },
                { 17, 18, 19, 202 }
        };

        int target = 100;

        int[] result = search(arr, target);     // return {row, col}
        System.out.println("Position is " + Arrays.toString(result));
    }

    static int[] search(int[][] arr, int target) {
        if (arr == null || arr.length == 0) return new int[]{-1, -1};

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{-1, -1};
    }
}

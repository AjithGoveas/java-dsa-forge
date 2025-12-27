package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*
            Consider matrix like below
            1 2 3
            4 5 6
            7 8 9
         */

        // 2D array
        int[][] arr2D = new int[3][3];

        // or directly
        int[][] arr2D_direct = {
                {1, 2, 3},      // 0th index
                {4, 5, 6},      // 1st index
                {7, 8, 9}       // 2nd index
        };

        System.out.println(Arrays.toString(arr2D_direct));  // shows the reference of the internal arrays
        System.out.println(Arrays.toString(arr2D_direct[0]));   // shows the 0th array of 2D
        System.out.println(Arrays.deepToString(arr2D_direct)); // shows the real array

        // Input of 2D array
        System.out.println("2D Input:");
        for (int row = 0; row < arr2D.length; row++) {
            for (int col = 0; col < arr2D[row].length; col++) {
                arr2D[row][col] = in.nextInt();
            }
        }

        // Output of 2D
        System.out.println("Simple output:");
        for (int row = 0; row < arr2D.length; row++) {
            for (int col = 0; col < arr2D[row].length; col++) {
                System.out.print(arr2D[row][col] + " ");
            }
            System.out.println();
        }

        // Enhanced output
        System.out.println("2D Enhanced Output:");
        for (int[] row: arr2D) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        // Simplistic Arrays print
        System.out.println("Arrays 2D: " + Arrays.deepToString(arr2D));
        in.close();
    }
}

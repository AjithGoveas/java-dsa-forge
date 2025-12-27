package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Primitive array
        int[] arr = new int[5];

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        // arr: [1, 2, 3, 4, 5]

        System.out.println(arr[3]); // 4

        System.out.print("Input: ");
        // Input using for loops
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Output: ");
        // Print array using for loops
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Enhanced print:");
        // Enhanced print
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

//        System.out.println(arr[6]); // ArrayIndexOutOfBoundException

        // For simplicity, we can use 'Arrays' package of Java
        System.out.println(Arrays.toString(arr));

        // Non-primitive array
        String[] arr2 = new String[5];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scanner.next();
        }

        System.out.println("String array: " + Arrays.toString(arr2));
        scanner.close();
    }
}

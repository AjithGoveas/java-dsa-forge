package Recursion;

import java.util.Scanner;

public class PrintName {
    // Print the given name 'count' times using recursion
    static void printName(String name, int count) {
        if (count == 0) return;         // base case — stop here
        System.out.println(name);       // print the name
        printName(name, count - 1);     // recursive call with reduced count
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = in.nextLine();

        System.out.print("How many times to print? ");
        int n = in.nextInt();

        printName(name, n);
        in.close();
    }
}
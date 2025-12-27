package Arrays;

public class Basics {
    public static void main(String[] args) {
        // 5 Roll numbers
        int[] rollNumbers = new int[5];
        // or directly
        int[] rollNumber2 = {12, 24, 35, 45};

        // After initialization
        System.out.println(rollNumbers[0]); // 0
        System.out.println(rollNumber2[0]); // 12

        String[] names = new String[5];
        System.out.println(names[0]); // null

        // Size of the array
        System.out.println("Array rollNumber2 size:" + rollNumber2.length);
    }
}

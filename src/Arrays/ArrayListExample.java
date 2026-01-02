package Arrays;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<Integer> list = new ArrayList<>(5);

        // Add elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("List upto initial size: " + list);

        list.add(6);
        list.add(7);
        list.add(8);

        System.out.println("List 3 items after initial size: " + list);

        // Check for element
        System.out.println("3: " + list.contains(3));
        System.out.println("35: " + list.contains(35));

        // Update element
        list.set(0, 99);
        System.out.println("After updating item 1: " + list);

        // Get an element
        System.out.println("Item at index 3: " + list.get(3));
    }
}

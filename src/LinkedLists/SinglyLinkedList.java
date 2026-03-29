package LinkedLists;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Node as a static nested class
    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // Insert node at the beginning
    public void insertFirst(int value) {
        head = new Node(value, head);

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // Insert node at the end
    public void insertLast(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Get tail node
    public Node getTail() {
        return tail;
    }

    // Get head node
    public Node getHead() {
        return head;
    }

    // Get size
    public int size() {
        return size;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // String representation
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" -> ");
            current = current.next;
        }
        sb.append("END");
        return sb.toString();
    }
}

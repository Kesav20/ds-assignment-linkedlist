class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the end of the list
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Link the last node to the new node
        temp.next = newNode;
    }

    // Method to delete the first occurrence of a given key
    public void delete(int key) {
        Node temp = head;
        Node prev = null;

        // Case 1: If the head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Move head to the next node
            System.out.println("Deleted " + key + " from the list.");
            return;
        }

        // Case 2: Search for the key to be deleted, keeping track of the previous node
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // Case 3: If the key was not present in the list
        if (temp == null) {
            System.out.println("Element " + key + " not found in the list.");
            return;
        }

        // Unlink the node from the linked list
        prev.next = temp.next;
        System.out.println("Deleted " + key + " from the list.");
    }

    // Method to display the elements of the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("--- Initializing Singly Linked List ---");
        list.display();

        System.out.println("\n--- Inserting Elements (10, 20, 30, 40) ---");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.display();

        System.out.println("\n--- Deleting Middle Element (20) ---");
        list.delete(20);
        list.display();

        System.out.println("\n--- Deleting Head Element (10) ---");
        list.delete(10);
        list.display();

        System.out.println("\n--- Attempting to Delete Non-existent Element (100) ---");
        list.delete(100);
        list.display();

        System.out.println("\n--- Deleting Remaining Elements ---");
        list.delete(30);
        list.delete(40);
        list.display();
    }
}
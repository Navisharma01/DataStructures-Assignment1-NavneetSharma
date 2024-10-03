package LabyrinthPath;

public class main {
    public static void main(String[] args) {
        // Create an instance of LabyrinthPath
        LabyrinthPath path = new LabyrinthPath();

        // Add some locations
        path.addLocation("Entrance");
        path.addLocation("Hallway");
        path.addLocation("Trap Room");
        path.addLocation("Treasure Chamber");

        // Print the path
        path.printPath();

        // Remove the last visited location
        System.out.println("\nRemoving last visited location: " + path.removeLastLocation());

        // Check if the path contains a loop (trap)
        System.out.println("\nPath contains loop? " + path.containsLoop());

        // Print the final path
        path.printPath();
    }
}

class LabyrinthPath {
    private Node head;
    private Node tail;

    public LabyrinthPath() {
        this.head = null;
        this.tail = null;
    }

    // Add a new location to the path
    public void addLocation(String location) {
        Node newNode = new Node(location);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove the last visited location
    public String removeLastLocation() {
        if (head == null) return "Path is empty.";

        if (head == tail) {
            String location = head.data;
            head = tail = null;
            return location;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        String location = tail.data;
        tail = current;
        tail.next = null;
        return location;
    }

    // Check if the path contains a loop (trap)
    public boolean containsLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Print the entire path
    public void printPath() {
        Node current = head;
        System.out.println("\nLabyrinth Path: ");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Node class for the singly linked list
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
}


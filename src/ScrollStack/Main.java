package ScrollStack;

public class Main {
    public static void main(String[] args) {
        // Create an instance of ScrollStack
        ScrollStack stack = new ScrollStack();

        // Push some scrolls onto the stack
        stack.push("Scroll of Knowledge");
        stack.push("Ancient Text");
        stack.push("Magic Scroll");

        // Peek at the top scroll
        System.out.println("Top of the stack: " + stack.peek());

        // Pop a scroll from the stack
        System.out.println("\nPopped: " + stack.pop());

        // Check if a specific scroll exists
        System.out.println("\nIs 'Magic Scroll' in the stack? " + stack.contains("Magic Scroll"));

        // Print the current stack
        stack.printStack();
    }
}

class ScrollStack {
    private Node top;

    public ScrollStack() {
        this.top = null;
    }

    // Push a scroll onto the stack
    public void push(String scroll) {
        Node newNode = new Node(scroll);
        newNode.next = top;
        top = newNode;
    }

    // Pop a scroll from the stack
    public String pop() {
        if (top == null) return "Stack is empty.";

        String scroll = top.data;
        top = top.next;
        return scroll;
    }

    // Peek at the top scroll without removing it
    public String peek() {
        if (top == null) return "Stack is empty.";
        return top.data;
    }

    // Check if a scroll exists in the stack
    public boolean contains(String scroll) {
        Node current = top;
        while (current != null) {
            if (current.data.equals(scroll)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Print the stack
    public void printStack() {
        Node current = top;
        System.out.println("\nCurrent Scroll Stack:");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Node class for the stack
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
}


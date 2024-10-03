package ExplorerQueue;

public class Main {
    public static void main(String[] args) {
        // Create an instance of ExplorerQueue with size 3
        ExplorerQueue queue = new ExplorerQueue(3);

        // Enqueue some explorers
        queue.enqueue("Indiana Jones");
        queue.enqueue("Lara Croft");
        queue.enqueue("Nathan Drake");

        // Display the next explorer
        System.out.println("Next Explorer: " + queue.peekNext());

        // Dequeue an explorer
        System.out.println("\nDequeue: " + queue.dequeue());

        // Check if the queue is full or empty
        System.out.println("\nIs the queue full? " + queue.isFull());
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}

class ExplorerQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int size;
    private int count;

    public ExplorerQueue(int size) {
        this.size = size;
        this.queue = new String[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // Enqueue an explorer
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("Queue is full.");
        } else {
            rear = (rear + 1) % size;
            queue[rear] = explorer;
            count++;
        }
    }

    // Dequeue an explorer
    public String dequeue() {
        if (isEmpty()) {
            return "Queue is empty.";
        } else {
            String explorer = queue[front];
            front = (front + 1) % size;
            count--;
            return explorer;
        }
    }

    // Display the next explorer in line
    public String peekNext() {
        if (isEmpty()) {
            return "Queue is empty.";
        } else {
            return queue[front];
        }
    }

    // Check if the queue is full
    public boolean isFull() {
        return count == size;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }
}

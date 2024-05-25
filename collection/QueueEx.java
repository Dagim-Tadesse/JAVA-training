package collection;

import java.util.Queue;
import java.util.LinkedList;

public class QueueEx {
    public static void main(String[] args) {
        // Create a Queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // Adding elements using offer()
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");
        System.out.println("Initial Queue: " + queue);

        // Retrieving the head element without removal
        System.out.println("Peek: " + queue.peek()); // Apple

        // Removing elements using poll()
        System.out.println("Poll: " + queue.poll()); // Removes and returns Apple
        System.out.println("Queue after Poll: " + queue);

        // Accessing the head element using element()
        System.out.println("Element: " + queue.element()); // Banana

        // Removing elements using remove()
        queue.remove(); // Removes Banana
        System.out.println("Queue after Remove: " + queue);

        // Trying to poll from an empty queue
        queue.poll(); // Removes Cherry
        System.out.println("Queue after removing last element: " + queue);
        System.out.println("Poll on Empty Queue: " + queue.poll()); // Returns null
        System.out.println("Peek on Empty Queue: " + queue.peek()); // Returns null

        // Adding elements back to the queue
        queue.offer("Date");
        queue.offer("Elderberry");
        System.out.println("Final Queue: " + queue);
    }
}

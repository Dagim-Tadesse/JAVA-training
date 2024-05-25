package collection;

import java.util.Deque;
import java.util.LinkedList;

public class DequeEx {
    public static void main(String[] args) {
        // Create a Deque using LinkedList
        Deque<String> deque = new LinkedList<>();

        // Adding elements at both ends
        deque.addFirst("Apple");
        deque.addLast("Banana");
        System.out.println("After addFirst and addLast: " + deque);

        // Accessing elements without removal
        System.out.println("First Element (getFirst): " + deque.getFirst());
        System.out.println("Last Element (getLast): " + deque.getLast());

        // Adding more elements
        deque.offerFirst("Cherry");
        deque.offerLast("Date");
        System.out.println("After offerFirst and offerLast: " + deque);

        // Removing elements from both ends
        System.out.println("Removed First (removeFirst): " + deque.removeFirst());
        System.out.println("Removed Last (removeLast): " + deque.removeLast());
        System.out.println("After removeFirst and removeLast: " + deque);

        // Accessing elements using peek methods
        System.out.println("Peek First (peekFirst): " + deque.peekFirst());
        System.out.println("Peek Last (peekLast): " + deque.peekLast());

        // Using as a stack
        deque.push("Elderberry");
        System.out.println("After push: " + deque);
        System.out.println("Popped Element (pop): " + deque.pop());
        System.out.println("After pop: " + deque);

        // Polling elements (safe removal)
        System.out.println("Polled First (pollFirst): " + deque.pollFirst());
        System.out.println("Polled Last (pollLast): " + deque.pollLast());
        System.out.println("After polling: " + deque);

        // Checking if the deque is empty
        System.out.println("Is the deque empty? " + deque.isEmpty());
    }
}

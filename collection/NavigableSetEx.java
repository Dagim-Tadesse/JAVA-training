package collection;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetEx {
    public static void main(String[] args) {
        // Create a NavigableSet using TreeSet
        NavigableSet<Integer> numbers = new TreeSet<>();

        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        System.out.println("Initial Set: " + numbers);

        // Navigational Methods
        System.out.println("Lower than 30: " + numbers.lower(30)); // 20
        System.out.println("Floor of 30: " + numbers.floor(30)); // 30
        System.out.println("Ceiling of 25: " + numbers.ceiling(25)); // 30
        System.out.println("Higher than 30: " + numbers.higher(30)); // 40

        // Access Methods
        System.out.println("Polling First (removes first): " + numbers.pollFirst()); // 10
        System.out.println("Polling Last (removes last): " + numbers.pollLast()); // 50
        System.out.println("After Polling: " + numbers);

        // View Methods
        System.out.println("Descending Set: " + numbers.descendingSet());
        System.out.println("Subset [20, 40] (inclusive): " + numbers.subSet(20, true, 40, true));
        System.out.println("HeadSet (less than or equal to 30): " + numbers.headSet(30, true));
        System.out.println("TailSet (greater than or equal to 30): " + numbers.tailSet(30, true));

        // Checking size
        System.out.println("Set Size: " + numbers.size());

        // Clearing the set
        numbers.clear();
        System.out.println("After clear(): " + numbers);
        System.out.println("Is the set empty? " + numbers.isEmpty());
    }
}

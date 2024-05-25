package collection;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetEx {
    public static void main(String[] args) {
        // Create a SortedSet using TreeSet
        SortedSet<Integer> numbers = new TreeSet<>();

        // Adding elements
        numbers.add(50);
        numbers.add(20);
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        System.out.println("Initial SortedSet: " + numbers);

        // Accessing boundaries
        System.out.println("First Element: " + numbers.first()); // 10
        System.out.println("Last Element: " + numbers.last()); // 50

        // Range views
        System.out.println("HeadSet (less than 30): " + numbers.headSet(30));
        System.out.println("TailSet (greater than or equal to 30): " + numbers.tailSet(30));
        System.out.println("SubSet (20 to 40): " + numbers.subSet(20, 40));

        // Checking if the set uses a comparator
        System.out.println("Comparator: " + numbers.comparator()); // null (natural ordering)

        // Adding a duplicate element (ignored)
        numbers.add(20);
        System.out.println("After Adding Duplicate (20): " + numbers);

        // Checking the size
        System.out.println("Set Size: " + numbers.size());

        // Clearing the set
        numbers.clear();
        System.out.println("After clear(): " + numbers);
        System.out.println("Is the set empty? " + numbers.isEmpty());
    }
}

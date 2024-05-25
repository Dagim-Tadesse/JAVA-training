package collection;

import java.util.Set;
import java.util.HashSet;

public class setEx {
    public static void main(String[] args) {
        // Create a Set
        Set<String> fruits = new HashSet<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("Initial Set: " + fruits);

        // Adding a duplicate element (will be ignored)
        fruits.add("Apple");
        System.out.println("After Adding Duplicate 'Apple': " + fruits);

        // Checking if an element exists
        System.out.println("Contains 'Banana': " + fruits.contains("Banana"));
        System.out.println("Contains 'Orange': " + fruits.contains("Orange"));

        // Removing an element
        fruits.remove("Banana");
        System.out.println("After Removing 'Banana': " + fruits);

        // Adding multiple elements
        Set<String> tropicalFruits = Set.of("Mango", "Papaya", "Pineapple");
        fruits.addAll(tropicalFruits);
        System.out.println("After addAll(tropicalFruits): " + fruits);

        // Removing multiple elements
        fruits.removeAll(Set.of("Cherry", "Mango"));
        System.out.println("After removeAll(Set.of('Cherry', 'Mango')): " + fruits);

        // Retaining only specific elements
        fruits.retainAll(Set.of("Apple", "Papaya"));
        System.out.println("After retainAll(Set.of('Apple', 'Papaya')): " + fruits);

        // Checking the size
        System.out.println("Set Size: " + fruits.size());

        // Checking if the set is empty
        System.out.println("Is the set empty? " + fruits.isEmpty());

        // Clearing the set
        fruits.clear();
        System.out.println("After clear(): " + fruits);
        System.out.println("Is the set empty now? " + fruits.isEmpty());
    }
}

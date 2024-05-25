package collection;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
    public static void main(String[] args) {
        // Create a List
        List<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("Initial List: " + fruits);

        // Adding an element at a specific index
        fruits.add(1, "Orange");
        System.out.println("After add(1, 'Orange'): " + fruits);

        // Accessing elements
        System.out.println("Element at Index 2: " + fruits.get(2));

        // Replacing an element
        fruits.set(2, "Blueberry");
        System.out.println("After set(2, 'Blueberry'): " + fruits);

        // Removing elements
        fruits.remove("Banana");
        System.out.println("After remove('Banana'): " + fruits);
        fruits.remove(0); // Removes "Apple" at index 0
        System.out.println("After remove(0): " + fruits);

        // Searching for elements
        System.out.println("Index of 'Orange': " + fruits.indexOf("Orange"));
        System.out.println("Last Index of 'Orange': " + fruits.lastIndexOf("Orange"));

        // Sublist
        fruits.add("Date");
        fruits.add("Elderberry");
        List<String> subList = fruits.subList(0, 2);
        System.out.println("SubList (0 to 2): " + subList);

        // Bulk operations
        List<String> tropicalFruits = List.of("Mango", "Papaya");
        fruits.addAll(tropicalFruits);
        System.out.println("After addAll(tropicalFruits): " + fruits);

        // Retain specific elements
        List<String> favorites = List.of("Mango", "Date");
        fruits.retainAll(favorites);
        System.out.println("After retainAll(favorites): " + fruits);

        // Clearing the list
        fruits.clear();
        System.out.println("After clear(): " + fruits);
        System.out.println("Is the list empty? " + fruits.isEmpty());
    }
}

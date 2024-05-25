package collection;

import java.util.ArrayList;
import java.util.Collection;

public class collectionEx {
    public static void main(String[] args) {
        // Create a collection
        Collection<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("Initial Collection: " + fruits);

        // Adding all elements from another collection
        Collection<String> moreFruits = new ArrayList<>();
        moreFruits.add("Date");
        moreFruits.add("Elderberry");
        fruits.addAll(moreFruits);
        System.out.println("After addAll(): " + fruits);

        // Removing an element
        fruits.remove("Banana");
        System.out.println("After remove('Banana'): " + fruits);

        // Checking if the collection contains a specific element
        System.out.println("Contains 'Apple': " + fruits.contains("Apple"));

        // Removing all elements from another collection
        fruits.removeAll(moreFruits);
        System.out.println("After removeAll(moreFruits): " + fruits);

        // Retaining only certain elements
        Collection<String> keep = new ArrayList<>();
        keep.add("Apple");
        keep.add("Cherry");
        fruits.retainAll(keep);
        System.out.println("After retainAll(keep): " + fruits);

        // Checking size
        System.out.println("Size of the collection: " + fruits.size());

        // Converting to an array
        Object[] fruitArray = fruits.toArray();
        System.out.println("Converted to array:");
        for (Object fruit : fruitArray) {
            System.out.println(fruit);
        }

        // Checking if the collection is empty
        System.out.println("Is the collection empty? " + fruits.isEmpty());

        // Clearing the collection
        fruits.clear();
        System.out.println("After clear(): " + fruits);
        System.out.println("Is the collection empty now? " + fruits.isEmpty());
    }
}

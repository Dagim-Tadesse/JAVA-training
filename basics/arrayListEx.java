import java.util.ArrayList;
import java.util.Collections;

public class arrayListEx {
    public static void main(String[] args) {
        // Creating an ArrayList of String type
        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        // Displaying the ArrayList
        System.out.println("Fruits: " + fruits);

        // Accessing elements by index
        String firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);

        // Updating elements by index
        fruits.set(1, "Blueberry");
        System.out.println("Updated Fruits: " + fruits);

        // Removing elements by index
        fruits.remove(3);
        System.out.println("Fruits after removal: " + fruits);

        // Removing elements by value
        fruits.remove("Cherry");
        System.out.println("Fruits after removing Cherry: " + fruits);

        // Iterating through the ArrayList
        System.out.println("Iterating through the list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Sorting the ArrayList
        Collections.sort(fruits);
        System.out.println("Sorted Fruits: " + fruits);

        // Checking if an element exists in the ArrayList
        boolean hasApple = fruits.contains("Apple");
        System.out.println("Contains Apple: " + hasApple);

        // Getting the size of the ArrayList
        int size = fruits.size();
        System.out.println("Size of the ArrayList: " + size);

        // Clearing all elements from the ArrayList
        fruits.clear();
        System.out.println("Fruits after clearing: " + fruits);
    }
}

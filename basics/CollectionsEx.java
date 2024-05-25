// java.util.Collections.
// This is a utility class provided in the Java standard library that contains
// static methods for performing various operations on collections, such as
// lists, sets, and maps.

// Here are some commonly used methods in the java.util.Collections class:

// sort(List<T> list): Sorts the specified list into ascending order.

// reverse(List<?> list): Reverses the order of the elements in the specified
// list.

// shuffle(List<?> list): Randomly permutes the elements in the specified list.

// max(Collection<? extends T> coll): Returns the maximum element of the given
// collection.

// min(Collection<? extends T> coll): Returns the minimum element of the given
// collection.

// binarySearch(List<? extends T> list, T key): Performs a binary search for the
// specified key in the specified list.

// swap(List<?> list, int i, int j): Swaps the elements at the specified
// positions in the specified list.

// fill(List<? super T> list, T obj): Replaces all elements of the specified
// list with the specified element.

// copy(List<? super T> dest, List<? extends T> src): Copies all elements from
// the source list to the destination list.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsEx {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");

        fruits.add("Cherry");
        fruits.add("Date");

        System.out.println("Original list: " + fruits);

        // Sorting the list
        Collections.sort(fruits);
        System.out.println("Sorted list: " + fruits);

        // Reversing the list
        Collections.reverse(fruits);
        System.out.println("Reversed list: " + fruits);

        // Shuffling the list
        Collections.shuffle(fruits);
        System.out.println("Shuffled list: " + fruits);

        // Finding the maximum and minimum elements
        String maxFruit = Collections.max(fruits);
        String minFruit = Collections.min(fruits);
        System.out.println("Max fruit: " + maxFruit);
        System.out.println("Min fruit: " + minFruit);
    }
}

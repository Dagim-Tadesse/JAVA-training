
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class listtest {

    public static void main(String[] args) {

        String[] colors = { "red", "blue", "gren", "black", "cat", "dog", "yellow" };
        List<String> list = new ArrayList<String>();

        for (String color : colors)
            list.add(color);

        System.out.println("----------list-----------\n");

        System.out.println("\nThe list: " + list);

        list.set(2, "green");
        System.out.println("\nAfter set(on 2): " + list);

        list.remove("cat");
        System.out.println("\nAfter remove('cat'): " + list);
        list.remove(4);
        System.out.println("\nAfter remove(5 or \"dog\"): " + list);

        String[] removeColors = { "red", "yellow" };
        List<String> removeList = new ArrayList<String>();

        for (String color : removeColors)
            removeList.add(color);

        System.out.println("ArrayList: ");

        for (int count = 0; count < list.size(); count++)
            System.out.printf("%s ", list.get(count));

        removeColors(list, removeList);

        System.out.println("\n\nArrayList after calling removeColors: ");

        for (String color : list)
            System.out.printf("%s ", color);

    }

    private static void removeColors(Collection<String> collection1, Collection<String> collection2) {
        Iterator<String> iterator = collection1.iterator();

        while (iterator.hasNext()) {
            if (collection2.contains(iterator.next()))
                iterator.remove();
        }

    }

}

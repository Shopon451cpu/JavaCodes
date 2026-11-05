package CollectionFrameWork;
import java.util.*;

public class ListDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("One");     // Adds "One" to the list
        list.add("Two");     // Adds "Two"
        list.add("Three");   // Adds "Three"

        // get()
        System.out.println(list.get(0)); // Gets element at index 1 → "Two"

        // set()
        list.set(0, "Updated"); // Replaces element at index 1 with "Updated"
        System.out.println(list); // Prints full list → [One, Updated, Three]

        // indexOf()
        System.out.println(list.indexOf("Updated")); // Returns first index of "Updated" → 1

        // lastIndexOf()
        list.add("Updated"); // Adds another "Updated" at the end
        System.out.println(list.lastIndexOf("Updated")); // Returns last occurrence index → 3

        // subList()
        System.out.println(list.subList(0,1)); // Returns elements from index 0 (inclusive) to 2 (exclusive) → [One, Updated]

        // replaceAll()
        list.replaceAll(s -> s + "+"); // Modifies each element by adding "+" at the end
        System.out.println(list); // [One+, Updated+, Three+, Updated+]

        // sort()
        list.sort(null); // Sorts list in natural (alphabetical) order
        System.out.println(list); // [One+, Three+, Updated+, Updated+]

        // of() → immutable list
        List<String> fixed = List.of("A", "B","C"); // Creates fixed (read-only) list
        System.out.println(fixed); // [A, B]
    }
}

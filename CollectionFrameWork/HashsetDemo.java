package CollectionFrameWork;
import java.util.*;

public class HashsetDemo {
    public static void main(String[] args) {

        // Create a HashSet
        HashSet<String> fruits = new HashSet<>();

        // 1. Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple"); // Duplicate (will not be added)

        // 2. Display elements
        System.out.println("HashSet elements: " + fruits);

        // 3. Check if element exists
        System.out.println("Contains Banana? " + fruits.contains("Banana"));

        // 4. Remove element
        fruits.remove("Mango");
        System.out.println("After removing Mango: " + fruits);

        // 5. Size of HashSet
        System.out.println("Size: " + fruits.size());

        // 6. Check if empty
        System.out.println("Is empty? " + fruits.isEmpty());

        // 7. Iterate through HashSet
        System.out.println("Iterating elements:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 8. Clear all elements
        fruits.clear();
        System.out.println("After clear: " + fruits);
    }
}
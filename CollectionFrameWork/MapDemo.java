package CollectionFrameWork;
import java.util.*;

public class MapDemo {
    public static void main(String[] args) {

        Map<String, Double> map = new HashMap<>();

        // put() → adds key-value pair into the map
        map.put("John", 1000.0); // key = "John", value = 1000.0
        map.put("Tom", 2000.0);  // key = "Tom", value = 2000.0

        // get() → returns value for a given key
        System.out.println(map.get("John")); // 1000.0

        // containsKey() → checks if a key exists in the map
        System.out.println(map.containsKey("Tom")); // true

        // containsValue() → checks if a value exists in the map
        System.out.println(map.containsValue(2000.0)); // true

        // entrySet() → returns all key-value pairs as Set of entries
        for(Map.Entry<String, Double> e : map.entrySet()) {
            // getKey() → returns key
            // getValue() → returns value
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

    }
}
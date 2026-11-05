package CollectionFrameWork;
import java.util.*;

public class AlgorithmDemo {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();

        list.add(20);
        list.add(8);
        list.add(1);
        list.add(5);

        System.out.println(list); // original list → [20, 8, 1, 5]

        // sort() → sorts elements in ascending (natural) order
        Collections.sort(list);
        System.out.println(list); // [1, 5, 8, 20]

        // reverseOrder() → provides reverse sorting logic
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list); // [20, 8, 5, 1]

        // shuffle() → randomly rearranges elements in the list
        Collections.shuffle(list);
        System.out.println(list); // random order (changes every run)

        // max() → returns the largest element in the list
        System.out.println(Collections.max(list));

        // min() → returns the smallest element in the list
        System.out.println(Collections.min(list));
    }
}
package CollectionFrameWork;
import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        // offer() → inserts element at the rear (end) of the queue
        q.offer(10);  // queue: [10]
        q.offer(20);  // queue: [10, 20]

        // peek() → returns front element WITHOUT removing it
        System.out.println(q.peek()); // 10 (front element)

        // element() → same as peek(), but throws exception if queue is empty
        System.out.println(q.element()); // 10 (front element)

        // poll() → removes and returns front element (safe version)
        System.out.println(q.poll()); // 10 removed, queue becomes [20]

        // remove() → removes and returns front element (throws exception if empty)
        System.out.println(q.remove()); // 20 removed, queue becomes []

        System.out.println(q); // [] (queue is now empty)
    }
}

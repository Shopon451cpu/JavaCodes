package CollectionFrameWork;
import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Iterator → used for forward-only traversal of collection
        Iterator<String> it = list.iterator();

        while(it.hasNext()) { // checks if next element exists
            System.out.print(it.next() + " "); // moves forward and prints element → A B C
        }
        System.out.println();

        // ListIterator → allows forward + backward traversal + modification
        ListIterator<String> litr = list.listIterator();

        // forward traversal + modification
        while(litr.hasNext()) {
            String val = litr.next();     // get next element
            litr.set(val + "+");          // modify current element in list
        }

        System.out.println(list); // [A+, B+, C+] (list is modified)

        // reverse traversal using ListIterator
        while(litr.hasPrevious()) { // moves backward
            System.out.print(litr.previous() + " "); // prints in reverse → C+ B+ A+
        }
        System.out.println();

        // Spliterator → used for parallel-style traversal (Java 8+)
        Spliterator<String> sp = list.spliterator();

        sp.forEachRemaining(System.out::print); // prints all elements → A+B+C+

        // ----------- Iterator remove() -----------

        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("B");
        list2.add("C");

        Iterator<String> it2 = list2.iterator();

        while(it2.hasNext()) {
            String val = it2.next();

            if(val.equals("B")) {
                it2.remove(); // remove using Iterator
            }
        }

        System.out.println("Iterator remove: " + list2); // [A, C]



// ----------- ListIterator remove() using backward traversal -----------

        List<String> list3 = new ArrayList<>();
        list3.add("A");
        list3.add("B");
        list3.add("C");

        ListIterator<String> litr2 = list3.listIterator();

// move cursor to end first
        while(litr2.hasNext()) {
            litr2.next();
        }

// now traverse backward
        while(litr2.hasPrevious()) {
            String val = litr2.previous();

            if(val.equals("B")) {
                litr2.remove(); // remove using previous()
            }
        }

        System.out.println("ListIterator remove (backward): " + list3); // [A, C]


    }
}
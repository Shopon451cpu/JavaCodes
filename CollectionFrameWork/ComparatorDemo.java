package CollectionFrameWork;
import java.util.*;

class MyComp implements Comparator<String> {

    // compare() → defines custom sorting rule for elements
   // public int compare(String a, String b) {
   //     return b.compareTo(a); // descending order (Z → A)
  //  }

  public int compare(String a, String b) {
       return a.compareTo(b); // ascending order (A → Z)
   }
}


public class ComparatorDemo {
    public static void main(String[] args) {

        // TreeSet → stores elements in sorted order
        // Here sorting is controlled by MyComp (custom comparator)
        TreeSet<String> set = new TreeSet<>(new MyComp());

        set.add("One");
        set.add("Two");
        set.add("Three");

        System.out.println(set); // prints elements in descending order

        // reversed() → reverses the sorting logic of comparator
        Comparator<String> comp = new MyComp().reversed();

        // compare() → compares two values using reversed rule
        System.out.println(comp.compare("A", "B"));
        // output depends on reversed order logic
    }
}
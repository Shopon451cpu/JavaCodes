package CollectionFrameWork;
import java.util.*;
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String>c = new ArrayList<>(); //arraylist creation with parent reference type.
        c.add("A"); //use of add func.
        c.add("B");
        c.add("C");
        System.out.println(c); //print
        Collection<String> c2 = new ArrayList<>();
        c2.add("D");
        c2.add("E");
        System.out.println(c2);
        c.addAll(c2);            // add one array to another using addAll() func
        System.out.println(c);
        System.out.println(c.contains("A")); //contains() func. if found return true else false.
        System.out.println(c.containsAll(c2)); //containsAll same. if all the elements of c2 exists in c then true else false
        c2.add("F");
        System.out.println(c.containsAll(c2));// now false.
        System.out.println(c.size()); // size
        System.out.println(c.isEmpty()); // empty check

        c.remove("D"); // removes "B"
        System.out.println(c);

        c.removeAll(c2);  //removes all of c2
        System.out.println(c);

        c.removeIf(s -> s.equals("C")); // removes "C" using lemda expression.element ke s dhoro pore compare koro.
        System.out.println(c);

        c.add("X");
        c.add("Y");
        c.retainAll(Arrays.asList("A","X")); // only specific item rahe bakidi remove. retainAll() func. array -> list.
        System.out.println(c);

        Object[] arr= c.toArray();
        System.out.println(Arrays.toString(arr));

        Iterator<String> it = c.iterator(); //normal print using iterator
        while (it.hasNext()){
            System.out.println(it.next()+" ");
        }
        c.clear();  //// clear() → removes all elements from collection
        System.out.println(c);


    }

}

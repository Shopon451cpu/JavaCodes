package CollectionFrameWork;
import java.util.*;

// 1. User-defined class
class Student {
    String name;
    int marks;
    int age;

    Student(String name, int marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    public String toString() {
        return name + "(" + marks + ", " + age + ")";
    }
}

// 2. Comparator (custom sorting rule)
class StudentComparator implements Comparator<Student> {

    public int compare(Student s1, Student s2) {

        // Rule 1: Sort by marks (descending)
        if (s1.marks != s2.marks) {
            return s2.marks - s1.marks;
        }

        // Rule 2: If marks same, sort by age (ascending)
        if (s1.age != s2.age) {
            return s1.age - s2.age;
        }

        // Rule 3: If both same, sort by name (A-Z)
        return s1.name.compareTo(s2.name);
    }
}

// 3. Main class
public class ComparatorStudent {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        // Adding students
        list.add(new Student("Rahim", 90, 22));
        list.add(new Student("Karim", 90, 20));
        list.add(new Student("Jamal", 80, 21));
        list.add(new Student("Abir", 90, 20));
        list.add(new Student("Siam", 80, 19));

        System.out.println("Before Sorting:");
        System.out.println(list);

        // Sorting using Comparator
        Collections.sort(list, new StudentComparator());

        System.out.println("\nAfter Sorting:");
        System.out.println(list);
    }
}

package TrackingSystem;
import java.util.Scanner;

public class AdmissionApp {
    static Scanner sc= new Scanner(System.in);
    static Student[] students=new Student[50];
    static int count=0;

    static void addStudents(){
        System.out.println("Enter the name: ");
        String name=sc.next();

        System.out.println("Enter id: ");
        int id= sc.nextInt();

        System.out.println("Enter ssc gpa: ");
        double ssc= sc.nextDouble();

        System.out.println("Enter hsc gpa: ");
        double hsc= sc.nextDouble();

        students[count++]=new Student(name,id,ssc,hsc);
        System.out.println("Added successfully.");
        System.out.println("=====================================");
    }

    static void vivaProcess(){
        System.out.println("Enter student id: ");
        int id= sc.nextInt();
        for (int i=0; i<count; i++){
            if(students[i].getId()==id){
             if(!students[i].getStatus().equalsIgnoreCase("Applied.")){
                 System.out.println("Viva not required.\n");
                 return;
             }
                System.out.println("Enter viva marks: ");
                int marks= sc.nextInt();
                if(marks>=8){
                    students[i].setStatus("Selected.");
                }else{
                    students[i].setStatus("Not Selected.");
                }
                System.out.println("Viva Updated!\n");
                return;
            }
        }
        System.out.println("Student not found.\n");
    }

    static void admittedStudent(){
        System.out.println("Enter student id: ");
        int id=sc.nextInt();

        for(int i=0; i<count; i++){
            if(students[i].getStatus().equalsIgnoreCase("Selected.")){
                students[i].setStatus("Admitted.");
                System.out.println("Student admitted.");
            }else{
                System.out.println("Not eligible for admission.");
            }
            return;
        }
        System.out.println("Student not found.\n");
    }

    static void viewSpecificStudent(){
        System.out.print("Enter Admission ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (students[i].getId()==id) {
                students[i].display();
                System.out.println();
                return;
            }
        }
        System.out.println("Student not found.\n");
    }

    static void viewAllStudents(){
        for (int i=0; i<count; i++){
            students[i].display();
        }
    }
    public static void main(String[] args) {

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Take Viva");
            System.out.println("3. Admit Student");
            System.out.println("4. View Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    vivaProcess();
                    break;
                case 3:
                    admittedStudent();
                    break;
                case 4:
                    viewSpecificStudent();
                    break;
                case 5:
                    viewAllStudents();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!\n");
            }
        }
    }

}

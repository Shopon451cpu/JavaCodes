package AnimalShelter;
import java.util.Scanner;
public class ManagerApp {
     Scanner sc = new Scanner(System.in);
      Pet[] p;
     int count =0;
   public ManagerApp(int n){
       p=new Pet[n];
    }
    public void addPet(){
        System.out.println("Enter name: ");
        String name= sc.next();
        System.out.println("Enter Identification Number: ");
        String identificationNumber=sc.next();

        System.out.println("Enter age: ");
        int age = sc.nextInt();

        System.out.println("Enter species: ");
        String species=sc.next();

        System.out.println("Is Healthy? (true/false)");
        boolean isHealthy= sc.nextBoolean();
        if(count<p.length) {
            p[count++] = new Pet(name, identificationNumber, age, species, isHealthy);
            System.out.println("Pet added successfully.");
        }else{
            System.out.println("No space left.");
        }

    }

  public void updateHealth(){
      System.out.println("Enter ID: ");
      String id=sc.next();
      for(int i=0; i<count;i++){
          if(p[i].getIdentificationNumber().equals(id)){
              p[i].markHealthy();
              return;
          }
      }
      System.out.println("Pet not found.");
  }

  public void viewPet(){
      System.out.println("Enter ID: ");
      String id=sc.next();
      for(int i=0; i<count;i++){
          if(p[i].getIdentificationNumber().equals(id)){
              p[i].display();
              return;
          }
      }
      System.out.println("Pet not found.");
  }

  public void showHealthyPets(){
      for(int i=0; i<count;i++){
          if(p[i].isHealthy()){
              p[i].display();
              System.out.println("-------------------");
          }
      }
  }

  public static void main(String[] args){
      Scanner sc= new Scanner(System.in);
      System.out.println("Enter the number of pets: ");
      int n= sc.nextInt();
      ManagerApp app= new ManagerApp(n);

      while(true){
          System.out.println("Press 1 to Add new pet.");
          System.out.println("Press 2 to update health.");
          System.out.println("press 3 to view specific pet.");
          System.out.println("press 4 to view healthy pets.");
          System.out.println("press 0 to exit.");

          System.out.println("Enter choice: ");
          int choice=sc.nextInt();

          switch(choice){
              case 1:
                  app.addPet();
                  break;
              case 2:
                  app.updateHealth();
                  break;
              case 3:
                  app.viewPet();
                  break;
              case 4:
                  app.showHealthyPets();
                  break;
              case 0:
                System.out.println("Exit");
                return;
              default:
                  System.out.println("Invalid choice.");
          }
      }
  }
}

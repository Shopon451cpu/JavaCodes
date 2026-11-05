package AnimalShelter;

public class Pet {
    private String name;
    private String identificationNumber;
    private int age;
    private String species;
    private boolean isHealthy;

    Pet(String name, String identificationNumber, int age, String species, boolean isHealthy) {
        this.name = name;
        this.identificationNumber = identificationNumber;
        this.age = age;
        this.species = species;
        this.isHealthy = isHealthy;
    }
    public void markHealthy(){
        isHealthy=true;
    }

    boolean isHealthy() {
        return this.isHealthy;
    }

    String getIdentificationNumber(){
        return identificationNumber;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + identificationNumber);
        System.out.println("Age: " + age);
        System.out.println("Species: " + species);
        System.out.println("Health Status: " + (isHealthy ? "Healthy" : "Not Healthy"));
        System.out.println("----------------------");

    }
}


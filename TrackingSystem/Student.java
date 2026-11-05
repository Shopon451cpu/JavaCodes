package TrackingSystem;

 class Student {
    private String name;
    private int id;
    private double sscGpa;
    private double hscGpa;
    private String status;

    Student(String name, int id, double sscGpa, double hscGpa){
        this.name=name;
        this.id=id;
        this.sscGpa=sscGpa;
        this.hscGpa=hscGpa;

        if(sscGpa+hscGpa>=9){
            this.status="Selected.";
        }else {
            this.status="Applied.";
        }
    }
    int getId(){
        return id;
    }
    String getStatus(){
        return status;
    }
    void setStatus(String status){
        this.status=status;
    }
    public void display(){
        System.out.println("===============Student information==============");
        System.out.println("Name: "+name);
        System.out.println("Id: "+id);
        System.out.println("SSC GPA: "+sscGpa);
        System.out.println("HSC GPA: "+hscGpa);
        System.out.println("Status: "+status);
    }
}

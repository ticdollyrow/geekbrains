package Lesson_5;

public class Employee {

    private String name; //ФИО
    private String position;
    private String email;
    private String phoneNumber;
    private float salary;
    private int age;

   public Employee(){
       this.name = "John Doe";
       this.position = "jobless";
   }

   public Employee(String name, String position, String email, String phoneNumber, float salary, int age){
       this.name = name;
       this.position = position;
       this.email= email;
       this.phoneNumber = phoneNumber;
       if( salary > 0.0f ) this.salary = salary;
       if ( age > 0 ) this.age = age;
   }

   public void info(){
       System.out.print("ФИО " + name + " возраст " + age + "\n");
       System.out.printf("должность %s  зарплата %.2f %n", position, salary );
       System.out.println("email " + email + " телефон " + phoneNumber );
   }

   public int getAge(){
       return this.age;
   }
}

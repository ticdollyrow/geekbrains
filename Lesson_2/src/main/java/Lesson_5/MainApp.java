package Lesson_5;

public class MainApp {

    public static void main(String[] args) {
        Employee[] arrPerson = new Employee[5];
           arrPerson[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000.00f, 30);
           arrPerson[1] = new Employee("Silva Kardinal", "dentist", "resident@gmail.com", "8(495)5674356", 48500.00f, 37);
           arrPerson[2] = new Employee();
           arrPerson[3] = new Employee("Roman Ignatov", "journalist", "roman@mail.com", "89774563478", 36786.00f, 45);
           arrPerson[4] = new Employee("Inga Rouse", "secretary", "inga@mailbox.com", "7896353567", 39000.00f, 41);

    for(int i = 0; i < arrPerson.length; i++){
        if( arrPerson[i].getAge() > 40 ) arrPerson[i].info();
    }
    }
}

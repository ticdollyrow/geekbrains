package Lesson_2;

public class HomeApp {
    public static void main(String[] args) {

        System.out.println(checkSum(18, 3));
        printPositiveOrNegative(-98);
        System.out.println(isNegative(-9));
        printText("Das Pass", 3);
        System.out.println(isLeapYear(2396));
    }

    public static  boolean checkSum(int a, int b){
        int sum = a + b;
        return ( sum > 10 && sum <= 20);

    }

    public static void printPositiveOrNegative(int zahl) {
        if( zahl >= 0){
            System.out.println("Positive");
            return;
        }
        System.out.println("Negative");
    }

    public static boolean isNegative(int zahl){
        return (zahl < 0);
    }

    public static void printText(String text, int n){
        for(int i =0; i < n; i++){
            System.out.println(text);
        }
    }

    public  static  boolean isLeapYear(int year){
        if( year % 4 == 0 && ( year % 100 != 0 || year % 400 == 0)){
            return true;
        }
        return false;
    }
}

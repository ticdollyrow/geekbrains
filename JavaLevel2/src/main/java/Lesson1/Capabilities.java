package Lesson1;

public interface Capabilities {

    void run();
    void jump();

    boolean check(int length);
    boolean check(double height);
    default boolean check(int lenght, int letLength){
        return lenght >= letLength;
    }

    default boolean check(double height, double letHeight){
        return (height - letHeight ) >= 0;
    }


}

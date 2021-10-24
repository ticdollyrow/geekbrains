package Lesson1;

import lombok.Getter;

public class Human implements Capabilities {
    private String name;
    @Getter
    int maxLength; // будем считать в метрах
    private double maxHeight;

    public Human(String name, int length, double height){
        this.name = name;
        this.maxLength = length;
        this.maxHeight = height;
    }
    @Override
    public void run() {
        System.out.println(name + " is running");

    }

    @Override
    public void jump() {
        System.out.println(name + " is jumping");
    }

    @Override
    public boolean check(int length) {
        return check(maxLength, length);
    }

    @Override
    public boolean check(double height) {
        return check(maxHeight, height);
    }
}

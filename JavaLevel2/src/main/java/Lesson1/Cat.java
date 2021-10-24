package Lesson1;

import lombok.Getter;

public class Cat implements Capabilities{
    @Getter
    private int maxLength;
    private double maxHeight;

    public Cat(int maxLength, double maxHeight) {
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    @Override
    public void run() {
        System.out.println("Cat is running");

    }

    @Override
    public void jump() {
        System.out.println("Cat is jumping");
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

package Lesson1;

import lombok.Getter;

public class Robot implements Capabilities{
    @Getter
    private int maxLength;
    private double maxHeight;

    public Robot(int maxLength, double maxHeight) {
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    @Override
    public void run() {
        System.out.println("Robot is running");
    }

    @Override
    public void jump() {
        System.out.println("Robot is jumping");
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

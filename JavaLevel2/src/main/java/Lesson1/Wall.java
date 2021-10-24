package Lesson1;

import lombok.Getter;

public class Wall implements Lets{
    @Getter
    double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean go(Capabilities member) {
        member.jump();
        return member.check(height);
    }
}

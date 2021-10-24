package Lesson1;

import lombok.Getter;

public class Treadmill implements Lets{
    @Getter private int length;

   public Treadmill(int length){
       this.length = length;
   }

    @Override
    public boolean go(Capabilities member) {
        member.run();
        return member.check(length);
    }
}
